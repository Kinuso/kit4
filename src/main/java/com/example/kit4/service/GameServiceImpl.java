package com.example.kit4.service;

import com.example.kit4.dto.TypeDto;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final ArrayList<Game> games = new ArrayList<>();

    @Override
    public ArrayList<Game> createGame(UUID userId, TypeDto typeDto) {

        Set<UUID> players = new HashSet<>();
        players.add(userId);

        switch (typeDto.gameName()) {
            case "connect4":
                players.add(typeDto.opponentId());
                ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();
                games.add(connectFourGameFactory.createGame(typeDto.boardSize(), players));
                break;

            case "15 puzzle":
                TaquinGameFactory taquinGameFactory = new TaquinGameFactory();
                games.add(taquinGameFactory.createGame(typeDto.boardSize(), players));
                break;

            case "tictactoe":
                players.add(typeDto.opponentId());
                TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
                games.add(ticTacToeGameFactory.createGame(typeDto.boardSize(), players));
                break;
            default:
                throw new IllegalArgumentException("Invalid game name");
        }

        return games;
    }

    @Override
    public ArrayList<Game> getGames() {
        return games;
    }

    @Override
    public List<GameFactory> getGame(String gameId) {
        return null;
    }
//        return games.stream()
//                .filter(game -> game.get(0).equals(gameId)) // Vérifie le premier élément (UUID)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Game not found with ID: " + gameId));
//    }

}
