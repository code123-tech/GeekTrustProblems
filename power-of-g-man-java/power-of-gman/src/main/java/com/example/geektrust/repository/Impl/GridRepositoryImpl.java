package com.example.geektrust.repository.Impl;

import com.example.geektrust.modal.Grid;
import com.example.geektrust.repository.IGridRepository;

import java.util.HashMap;
import java.util.Map;

public class GridRepositoryImpl implements IGridRepository {
    private Map<Integer, Grid> store = new HashMap<>();
    private static Integer counter = 1;

    @Override
    public Grid save(Grid grid) {
        if(grid.getId() == null){
            grid.setId(counter);
            counter++;
        }
        this.store.put(grid.getId(), grid);
        return grid;
    }

    @Override
    public Grid findById(Integer id) {
        return store.getOrDefault(id, null);
    }
}
