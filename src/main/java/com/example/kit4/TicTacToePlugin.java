// TicTacToePlugin.java
package com.example.kit4;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TicTacToePlugin implements GamePlugin {

    @Autowired
    private MessageSource messageSource;

    @Value("${game.tictactoe.default-player-count}")
    private int defaultPlayerCount;

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage("game.tictactoe.name", null, locale);
    }

    @Override
    public Game createGame(Integer playerCount, Integer boardSize) {
        TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
        return ticTacToeGameFactory.createGame(playerCount, boardSize);
    }
}