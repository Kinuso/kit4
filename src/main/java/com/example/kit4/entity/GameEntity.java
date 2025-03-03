package com.example.kit4.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.UUID;

@Entity
public class GameEntity {
    @Id
    public UUID id;
    public @NotNull String factoryId;
    public @Positive int boardSize;
    public UUID playerIds;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<GameTokenEntity> tokens;

    public GameEntity(String factoryId, int boardSize, UUID playerIds) {
        this.id = UUID.randomUUID();
        this.factoryId = factoryId;
        this.boardSize = boardSize;
        this.playerIds = playerIds;

    }

    public GameEntity() {

    }
}
