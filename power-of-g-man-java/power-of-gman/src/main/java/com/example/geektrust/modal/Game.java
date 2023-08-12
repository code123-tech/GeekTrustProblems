package com.example.geektrust.modal;

import com.example.geektrust.common.enums.Direction;

public class Game {
    private Integer id;
    private Point src;
    private Point dest;
    private Direction direction;
    private Grid grid;
    private Integer INITIAL_POWER;

    public Point getSrc() {
        return src;
    }

    public void setSrc(Point src) {
        this.src = src;
    }

    public Point getDest() {
        return dest;
    }

    public void setDest(Point dest) {
        this.dest = dest;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getINITIAL_POWER() {
        return INITIAL_POWER;
    }

    public void setINITIAL_POWER(Integer INITIAL_POWER) {
        this.INITIAL_POWER = INITIAL_POWER;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
