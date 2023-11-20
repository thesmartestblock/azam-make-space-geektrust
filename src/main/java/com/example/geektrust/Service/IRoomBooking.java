package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

public interface IRoomBooking{
    String bookRoom(Slot newSlot,int capacity) throws NoRoomsException, InvalidInputException;
}
