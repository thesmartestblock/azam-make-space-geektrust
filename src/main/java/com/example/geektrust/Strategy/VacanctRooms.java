package com.example.geektrust.Strategy;

import java.util.List;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;

public class VacanctRooms {

    private final List<MeetingRoom> rooms;

    public VacanctRooms(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    public String checkVacancy(Slot slot) {
        try {
            slot.isValidTimeCheck();
        }catch (Exception e){
            return "NO_VACANT_ROOM";
        }
        StringBuilder sb = new StringBuilder();

            for (MeetingRoom room : rooms) {
                if (room.availableSlot(slot))
                    sb.append(room.getRoomName()).append(" ");
            }

        if(sb.length() == 0){
            return "NO_VACANT_ROOM";
        }
//        sb.;
        return sb.toString().trim();
    }
}
