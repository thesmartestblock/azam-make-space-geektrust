package com.example.geektrust.Exceptions;

public class NoRoomsException extends Exception{
    private static final String NO_ROOMS = "NO_VACANT_ROOM";
    public NoRoomsException(){
        super(NO_ROOMS);
    }
}
