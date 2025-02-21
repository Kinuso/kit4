package com.example.kit4.controller;

import com.example.kit4.dto.TypeDto;
import com.example.kit4.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;


    @PostMapping("/games")
    public ArrayList<List<String>> createGame(@RequestBody TypeDto typeDto) {
        return gameService.createGame(typeDto);
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

