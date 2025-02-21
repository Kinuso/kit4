package com.example.kit4.service;

import com.example.kit4.dto.TypeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final ArrayList<List<String>> games = new ArrayList<>();

    @Override
    public ArrayList<List<String>> createGame(TypeDto typeDto) {
        List<String> gameData = List.of(UUID.randomUUID().toString(), typeDto.gameName());
        games.add(gameData);
        return new ArrayList<>(games);
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
