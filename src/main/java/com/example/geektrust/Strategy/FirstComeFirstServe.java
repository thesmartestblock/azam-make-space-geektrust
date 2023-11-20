package com.example.geektrust.Strategy;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;

import java.util.List;

public class FirstComeFirstServe implements RoomBookingStrategy {

    private static final String NO_ROOMS = "NO_VACANT_ROOM";

    private final List<MeetingRoom> rooms;

    public FirstComeFirstServe(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String BookRoom(Slot newSlot, int capacity) {
        checkCapacity(capacity);
        newSlot.isValidTimeCheck();
        for (MeetingRoom room : rooms) {
            if (canAllocateRoom(room, newSlot, capacity)) {
                return room.getRoomName();
            }
        }
        return NO_ROOMS;
    }

    private boolean canAllocateRoom(MeetingRoom room, Slot newSlot, int capacity) {
        return room.reserveSlot(newSlot, capacity);
    }

    private void checkCapacity(int capacity) {

        int maxCapacityAllowed = 20;
        int minCapacityAllowed = 2;
        if (capacity < minCapacityAllowed || capacity > maxCapacityAllowed)
            throw new IllegalArgumentException(NO_ROOMS);

    }

}
