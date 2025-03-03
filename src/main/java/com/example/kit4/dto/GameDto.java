package com.example.kit4.dto;

import java.util.UUID;

public record GameDto(String id, String name, String status, UUID currentPlayer) {
}
