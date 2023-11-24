package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.NoRoomsException;

public interface IRepository {
    String allocateRoom(Booking booking) throws NoRoomsException;

    String checkVacancy(Booking booking) throws NoRoomsException;
}
