package com.example.kit4.service;

import com.example.kit4.dto.TypeDto;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface GameService {
    GameFactory createGame(String userId, TypeDto typeDto);

    ArrayList<List<String>> getGames();

    List<String> getGame(String gameId);
}
