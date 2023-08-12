package com.example.geektrust.repository;

import com.example.geektrust.modal.Point;

public interface IPointRepository {
    Point save(Point point);
    Point getByXAndY(Integer x, Integer y);
}
