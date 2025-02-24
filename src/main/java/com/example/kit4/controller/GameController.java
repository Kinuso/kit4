package com.example.kit4.controller;

import com.example.kit4.dto.TypeDto;
import com.example.kit4.service.GameService;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;



    @PostMapping("/games")
    public GameFactory createGame(@RequestHeader("X-UserId") String userId, @RequestBody TypeDto typeDto) {
        return gameService.createGame(userId, typeDto);
    }

    @GetMapping("/games")
    public ArrayList<List<String>> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/games/{gameId}")
    public List<String> getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }

//    @GetMapping("/games/{userId}")
//    public List<GameDto> getGames(@RequestHeader("X-UserId") String userId) {
//        return gameService.getAllGames(userId);
//    }
}

