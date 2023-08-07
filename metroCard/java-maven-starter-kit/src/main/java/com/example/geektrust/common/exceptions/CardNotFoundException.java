package com.example.geektrust.common.exceptions;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException()
    {
        super();
    }
    public CardNotFoundException(String msg)
    {
        super(msg);
    }
}
