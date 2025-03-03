package com.example.kit4.controller;

import com.example.kit4.dto.GameDto;
import com.example.kit4.dto.TypeDto;
import com.example.kit4.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    public Game createGame(@RequestHeader("X-UserId") UUID userId, @RequestBody TypeDto typeDto) {
        return gameService.createGame(userId, typeDto);
    }

    @GetMapping("/games")
    public ArrayList<Game> getGames(@RequestHeader("X-UserId") UUID userId) {
        return gameService.getGames(userId);
    }

    @GetMapping("/games/{gameId}")
    public GameDto getGame(@PathVariable UUID gameId) {
        return gameService.getGame(gameId);
    }

    @PostMapping("/games/{gameId}/move")
    public ResponseEntity<String> makeMove(@RequestHeader("X-UserId") UUID userId, @PathVariable UUID gameId) {
        return gameService.makeMove(gameId, userId);
    }
//    @GetMapping("/games/{userId}")
//    public List<GameDto> getGames(@RequestHeader("X-UserId") String userId) {
//        return gameService.getAllGames(userId);
//    }
}

