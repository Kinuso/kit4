package com.example.kit4.service;

import com.example.kit4.dto.TypeDto;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public interface GameService {
    ArrayList<Game> createGame(UUID userId, TypeDto typeDto);

    ArrayList<Game> getGames();

    List<GameFactory> getGame(String gameId);
}
