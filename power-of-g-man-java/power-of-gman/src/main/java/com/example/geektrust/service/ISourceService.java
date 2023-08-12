package com.example.geektrust.service;

import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.modal.Point;

public interface ISourceService {
    Point addPoint(Point point, String direction, Integer initialPower);
}
