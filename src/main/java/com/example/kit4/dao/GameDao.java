package com.example.kit4.dao;

import com.example.kit4.dto.TypeDto;
import com.example.kit4.entity.GameEntity;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameDao {

    List<GameEntity> findAll();
    Optional<GameEntity> findById(@NotNull String gameId);
    GameEntity upsert(TypeDto typeDto, UUID userId);

    GameEntity upsert(GameEntity gameEntity);

    void delete(@NotNull String gameId);
}
