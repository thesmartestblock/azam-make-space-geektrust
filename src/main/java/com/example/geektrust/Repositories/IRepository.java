package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.NoRoomsException;

public interface IRepository {
    String allocateRoom(Slot newSlot, int capacity) throws NoRoomsException ;
    String checkVacancy(Slot slot) throws NoRoomsException ;
}
