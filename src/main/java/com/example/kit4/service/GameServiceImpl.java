package com.example.kit4.service;

import com.example.kit4.dto.TypeDto;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGame;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final ArrayList<List<String>> games = new ArrayList<>();

    @Override
    public GameFactory createGame(String userId, TypeDto typeDto) {

        Set<UUID> players = new HashSet<>();
        players.add(UUID.fromString(userId));
        players.add(UUID.fromString(typeDto.opponentId()));

        switch (typeDto.gameName()) {
            case "connect4":
                ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();
                connectFourGameFactory.createGame(typeDto.boardSize(), players);
                return connectFourGameFactory;

            case "15 puzzle":
                TaquinGameFactory taquinGameFactory = new TaquinGameFactory();
                taquinGameFactory.createGame(typeDto.boardSize(), players);
                return taquinGameFactory;

            case "tictactoe":
                TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
                ticTacToeGameFactory.createGame(typeDto.boardSize(), players);
                return ticTacToeGameFactory;

            default:
                throw new IllegalArgumentException("Invalid game name");
        }
    }

    @Override
    public ArrayList<List<String>> getGames() {
        return games;
    }

    @Override
    public List<String> getGame(String gameId) {
        return games.stream()
                .filter(game -> game.get(0).equals(gameId)) // Vérifie le premier élément (UUID)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Game not found with ID: " + gameId));
    }

}
