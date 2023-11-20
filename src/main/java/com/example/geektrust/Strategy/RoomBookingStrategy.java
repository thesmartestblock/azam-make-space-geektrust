package com.example.geektrust.Strategy;

import com.example.geektrust.DTO.Slot;

public interface RoomBookingStrategy {
    String BookRoom(Slot newSlot,int capacity);   
}
