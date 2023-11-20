package com.example.geektrust.Exceptions;

public class InvalidInputException extends Exception{
    private static final String INVALID_INPUT = "INCORRECT_INPUT";
    public InvalidInputException(){
        super(INVALID_INPUT);
    }
}
