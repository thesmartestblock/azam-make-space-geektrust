package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

public interface IVacantRooms{

    public String checkVacancy(Slot slot) throws NoRoomsException, InvalidInputException;
}
