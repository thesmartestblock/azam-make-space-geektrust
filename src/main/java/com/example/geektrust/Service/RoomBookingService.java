package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;
import com.example.geektrust.Repositories.IRepository;

public class RoomBookingService implements IRoomBookingService {
    private final IRepository repo;

    public RoomBookingService(IRepository repo) {
        this.repo = repo;
    }

    public void bookRoom(Booking newBooking) throws NoRoomsException {
        System.out.println(repo.allocateRoom(newBooking));
    }
}