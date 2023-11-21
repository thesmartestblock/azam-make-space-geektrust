package com.example.geektrust.Service;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class RoomBookingService implements IRoomBooking {

    private final List<MeetingRoom> rooms;

    public RoomBookingService(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String bookRoom(Slot newSlot, int capacity) throws NoRoomsException, InvalidInputException {
        checkCapacity(capacity);
        TimeService.inBufferTime(newSlot);
        return allocateRoom(newSlot, capacity);
    }

    private String allocateRoom(Slot newSlot, int capacity) throws NoRoomsException {
        return rooms.stream().filter((r)-> r.reserveSlot(newSlot,capacity)).findFirst()
                .orElseThrow(NoRoomsException::new).getRoomName();
    }

    private void checkCapacity(int capacity) throws NoRoomsException {

        int maxCapacityAllowed = 20;
        int minCapacityAllowed = 2;
        if (capacity < minCapacityAllowed || capacity > maxCapacityAllowed)
            throw new NoRoomsException();

    }

}
