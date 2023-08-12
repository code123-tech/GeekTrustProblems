package com.example.geektrust.modal;

public class Grid {
    private Integer id;
    private Point[][] grid;

    public Grid(){
        this.grid = new Point[7][7];
    }

    public Point[][] getGrid() {
        return grid;
    }

    public Point getCell(Integer i, Integer j){
        return this.grid[i][j];
    }

    public void setCell(Integer i, Integer j, Point point){
        this.grid[i][j] = point;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
}
