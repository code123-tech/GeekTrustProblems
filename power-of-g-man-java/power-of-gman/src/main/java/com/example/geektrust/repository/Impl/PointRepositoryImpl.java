package com.example.geektrust.repository.Impl;

import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.IPointRepository;

import java.util.HashMap;
import java.util.Map;

public class PointRepositoryImpl implements IPointRepository {
    private Map<String, Point> store = new HashMap<>();

    @Override
    public Point save(Point point) {
        String key = point.getX() + " " + point.getY();
        if(!store.containsKey(key)){
            store.put(key, point);
        }
        return store.get(key);
    }

    @Override
    public Point getByXAndY(Integer x, Integer y) {
        String key = x + " " + y;
        return store.getOrDefault(key, null);
    }
}
