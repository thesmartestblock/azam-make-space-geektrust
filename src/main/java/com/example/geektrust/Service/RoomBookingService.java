package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.NoRoomsException;
import com.example.geektrust.Repositories.IRepository;

public class RoomBookingService implements IRoomBooking {

    private final IRepository repository;

    public RoomBookingService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public String bookRoom(Slot newSlot, int capacity) throws NoRoomsException {
        checkCapacity(capacity);
        return repository.allocateRoom(newSlot, capacity);
    }


    private void checkCapacity(int capacity) throws NoRoomsException {

        int maxCapacityAllowed = 20;
        int minCapacityAllowed = 2;
        if (capacity < minCapacityAllowed)
            throw new NoRoomsException();
        if (capacity > maxCapacityAllowed)
            throw new NoRoomsException();

    }

}
