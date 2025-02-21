package com.example.kit4.controller;

import com.example.kit4.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/catalog")
    public Collection<String> getGameCatalog() {
        return gameCatalog.getGameIdentifiers();
    }
}
