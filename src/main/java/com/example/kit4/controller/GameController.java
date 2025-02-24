package com.example.kit4.controller;

import com.example.kit4.dto.TypeDto;
import com.example.kit4.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;



    @PostMapping("/games")
    public ArrayList<Game> createGame(@RequestHeader("X-UserId") UUID userId, @RequestBody TypeDto typeDto) {
        return gameService.createGame(userId, typeDto);
    }

    @GetMapping("/games")
    public ArrayList<Game> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/games/{gameId}")
    public List<GameFactory> getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }

//    @GetMapping("/games/{userId}")
//    public List<GameDto> getGames(@RequestHeader("X-UserId") String userId) {
//        return gameService.getAllGames(userId);
//    }
}

