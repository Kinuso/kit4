package com.example.kit4.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class GameTokenEntity {
    @Id
    public UUID id;
    public @NotNull String ownerId;
    public @NotNull String name;
    public boolean removed;
    public @Nullable Integer x;
    public @Nullable Integer y;
}
