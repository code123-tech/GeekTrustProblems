package com.example.geektrust.common.exceptions;

public class DirectionNotFoundException extends RuntimeException{
    public DirectionNotFoundException()
    {
        super();
    }
    public DirectionNotFoundException(String msg)
    {
        super(msg);
    }
}
