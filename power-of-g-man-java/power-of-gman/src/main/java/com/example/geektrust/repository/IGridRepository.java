package com.example.geektrust.repository;

import com.example.geektrust.modal.Grid;

public interface IGridRepository {
    Grid save(Grid grid);
    Grid findById(Integer id);
}
