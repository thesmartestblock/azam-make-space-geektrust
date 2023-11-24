package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.NoRoomsException;

public interface IBookingRepo {
    String allocateRoom(Booking booking) throws NoRoomsException;
}
