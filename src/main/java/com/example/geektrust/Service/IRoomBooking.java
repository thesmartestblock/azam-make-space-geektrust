package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;

public interface IRoomBooking{
    String bookRoom(Slot newSlot,int capacity);
}
