package com.example.geektrust.Service;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;

import java.util.List;

public class RoomBooking implements IRoomBooking {

    private static final String NO_ROOMS = "NO_VACANT_ROOM";

    private final List<MeetingRoom> rooms;

    public RoomBooking(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String bookRoom(Slot newSlot, int capacity) {
        checkCapacity(capacity);
        newSlot.isValidTimeCheck();
        return allocateRoom(newSlot,capacity);
    }

    private String allocateRoom(Slot newSlot, int capacity) {
        for (MeetingRoom room : rooms) {
            if (room.reserveSlot(newSlot, capacity)) {
                return room.getRoomName();
            }
        }
        return NO_ROOMS;
    }

    private void checkCapacity(int capacity) {

        int maxCapacityAllowed = 20;
        int minCapacityAllowed = 2;
        if (capacity < minCapacityAllowed || capacity > maxCapacityAllowed)
            throw new IllegalArgumentException(NO_ROOMS);

    }

}
