package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

public interface IVacantRoomsService {
    void checkVacancy(Booking check) throws NoRoomsException, InvalidInputException;
}
