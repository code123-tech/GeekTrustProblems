package com.example.geektrust.repository;

import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Grid;

public interface IGameRepository {
    Game save(Game game);
    Game findById(Integer id);
}
