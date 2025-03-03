package com.example.kit4;

import java.util.Collection;
import java.util.Locale;

public interface GameCatalog {

    Collection<String> getGameIdentifiers(Locale locale);
}
