package com.example.kit4.service;

import com.example.kit4.GamePlugin;
import com.example.kit4.TicTacToePlugin;
import com.example.kit4.dao.GameDao;
import com.example.kit4.dto.GameDto;
import com.example.kit4.dto.TypeDto;
import com.example.kit4.dto.UserDto;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GameDao gameDao;

    private final ArrayList<Game> games = new ArrayList<>();

    @Autowired
    private List<GamePlugin> gamePlugins;

    @Override
    public Game createGame(UUID userId, TypeDto typeDto) {

        isValidUser(userId);
        Set<UUID> players = new HashSet<>();
        players.add(userId);
        Game game;

        switch (typeDto.gameName()) {
            case "connect4":
                players.add(typeDto.opponentId());
                TicTacToePlugin ticTacToePlugin = new TicTacToePlugin();
                ticTacToePlugin.createGame(players.size(), typeDto.boardSize());
                game = new ConnectFourGameFactory().createGame(typeDto.boardSize(), players);
                break;

            case "15 puzzle":
                game = new TaquinGameFactory().createGame(typeDto.boardSize(), players);
                break;

            case "tictactoe":
                players.add(typeDto.opponentId());
                game = new TicTacToeGameFactory().createGame(typeDto.boardSize(), players);
                break;

            default:
                throw new IllegalArgumentException("Invalid game name");
        }
        games.add(game);
        return game;
    }

    @Override
    public ArrayList<Game> getGames(UUID userId) {
        ArrayList<Game> userGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getPlayerIds().contains(userId)) {
                userGames.add(game);
            }
        }
        return userGames;
    }

    @Override
    public GameDto getGame(UUID gameId) {

        Game game = games.stream()
                .filter(g -> g.getId().equals(gameId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Partie introuvable"));

        return new GameDto(game.getId().toString(), game.getFactoryId(), game.getStatus().toString(), game.getCurrentPlayerId());
    }

    @Override
    public ResponseEntity<String> makeMove(UUID gameId, UUID playerId) {
        GameDto game = getGame(gameId);
        if (!game.currentPlayer().equals(playerId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Joueur en cours incorrect");
        } else {
            return ResponseEntity.ok("OK");
        }
    }

    private void isValidUser(UUID userId) {

        String url = "http://localhost:8081/users/"+ userId + "/validate";
        try {
            UserDto response = restTemplate.getForObject(url, UserDto.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new IllegalArgumentException("Invalid user ID");
        }
    }
//
//    @Override
//    public List<GameEntity> findAll() {
//        // Faire la conversion entre game et gameEntity
//        return jpaGameDao.findAll();
//    }
//
//    @Override
//    public Optional<GameEntity> findById(String gameId) {
//
//        Optional<GameEntity> game = jpaGameDao.findById(gameId);
//
//        switch (gameEntity.factoryId) {
//            case "connect4":
//                players.add() // Trouver où récup l'id de l'adversaire
//                game = new ConnectFourGameFactory().createGame(gameEntity.get().boardSize, game.getPlayerIds());
//                break;
//
//            case "15 puzzle":
//                game = new TaquinGameFactory().createGame(gameEntity.get().boardSize, game.getPlayerIds());
//                break;
//
//            case "tictactoe":
//                players.add() // Trouver où récup l'id de l'adversaire
//                game = new TicTacToeGameFactory().createGame(gameEntity.get().boardSize, game.getPlayerIds());
//                break;
//
//            default:
//                throw new IllegalArgumentException("Invalid game name");
//        }
//
//        return game;
//    }
//
//    @Override
//    public GameEntity upsert(TypeDto typeDto, UUID userId) {
//
//        isValidUser(userId);
//        GameEntity gameEntity = new GameEntity(typeDto.gameName(), typeDto.boardSize(), userId);
//        jpaGameDao.upsert(gameEntity);
//        return gameEntity;
//    }
//
//    @Override
//    public GameEntity upsert(GameEntity gameEntity) {
//        return null;
//    }
//
//    @Override
//    public void delete(String gameId) {
//
//    }

}
