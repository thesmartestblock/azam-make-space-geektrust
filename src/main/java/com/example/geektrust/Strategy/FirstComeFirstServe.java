package com.example.geektrust.Strategy;

import java.util.List;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;

public class FirstComeFirstServe implements RoomBookingStrategy {

    private final List<MeetingRoom> rooms;

    public FirstComeFirstServe(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String BookRoom(Slot newSlot, int capacity) {
        if (capacity < 2 || capacity > 20)
            throw new IllegalArgumentException("NO_VACANT_ROOM");
        newSlot.isValidTimeCheck();
        for(MeetingRoom room : rooms){
            if(room.reserveSlot(newSlot, capacity)){
                return room.getRoomName();
            }
        }
        return "NO_VACANT_ROOM";
    }

}
