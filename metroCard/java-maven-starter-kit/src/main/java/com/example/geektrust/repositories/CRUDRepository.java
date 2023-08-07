package com.example.geektrust.repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T,ID> {
    T save(T entity);
}