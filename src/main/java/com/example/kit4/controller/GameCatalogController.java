package com.example.kit4.controller;

import com.example.kit4.GameCatalog;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Locale;

@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/catalog")
    public Collection<String> getGameCatalog(@RequestHeader("Accept-Language") Locale locale) {
        return gameCatalog.getGameIdentifiers(locale);
    }
}
