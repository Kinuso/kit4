package com.example.kit4.service;

import com.example.kit4.dto.TypeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface GameService {
    ArrayList<List<String>> createGame(TypeDto typeDto);

    ArrayList<List<String>> getGames();

    List<String> getGame(String gameId);
}
