package com.example.geektrust.common.exceptions;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException()
    {
        super();
    }
    public GameNotFoundException(String msg)
    {
        super(msg);
    }
}
