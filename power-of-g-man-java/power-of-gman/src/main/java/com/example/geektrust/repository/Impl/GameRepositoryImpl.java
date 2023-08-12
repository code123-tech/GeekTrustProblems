package com.example.geektrust.repository.Impl;

import com.example.geektrust.modal.Game;
import com.example.geektrust.repository.IGameRepository;

import java.util.HashMap;
import java.util.Map;

public class GameRepositoryImpl implements IGameRepository {
    private Map<Integer, Game> store = new HashMap<>();
    private static Integer counter = 1;

    @Override
    public Game save(Game game) {
        if(game.getId() == null){
            game.setId(counter);
            counter++;
        }
        this.store.put(game.getId(), game);
        return game;
    }

    @Override
    public Game findById(Integer id) {
        return store.getOrDefault(id, null);
    }
}
