package com.example.kit4.service;

import com.example.kit4.GameCatalog;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {

    @Override
    public Collection<String> getGameIdentifiers() {
        return List.of("TicTacToe", "Gomoku", "Chess");
    }

}
