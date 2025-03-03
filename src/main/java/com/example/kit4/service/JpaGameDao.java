package com.example.kit4.service;

import com.example.kit4.dao.GameDao;
import com.example.kit4.dto.TypeDto;
import com.example.kit4.entity.GameEntity;
import com.example.kit4.repository.GameEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JpaGameDao implements GameDao {

    @Autowired
    GameEntityRepository gameEntityRepository;

    @Override
    public List<GameEntity> findAll() {
        return gameEntityRepository.findAll();
    }

    @Override
    public Optional<GameEntity> findById(String gameId) {
        return gameEntityRepository.findById(gameId);
    }

    @Override
    public GameEntity upsert(TypeDto typeDto, UUID userId) {
        return null;
    }

    @Override
    public GameEntity upsert(GameEntity gameEntity) {
        return gameEntityRepository.save(gameEntity);
    }

    @Override
    public void delete(String gameId) {

    }
}
