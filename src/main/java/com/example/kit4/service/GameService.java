package com.example.kit4.service;

import com.example.kit4.dto.GameDto;
import com.example.kit4.dto.TypeDto;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public interface GameService {
    Game createGame(UUID userId, TypeDto typeDto);

    ArrayList<Game> getGames(UUID userId);

    GameDto getGame(UUID gameId);

    ResponseEntity<String> makeMove(UUID gameId, UUID playerId);
}
