package com.example.kit4.dto;

import java.util.UUID;

public record TypeDto(String gameName, UUID opponentId, int boardSize) {
}
