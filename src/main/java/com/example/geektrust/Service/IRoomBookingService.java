package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

public interface IRoomBookingService {
    void bookRoom(Booking newBooking) throws InvalidInputException, NoRoomsException;
}
