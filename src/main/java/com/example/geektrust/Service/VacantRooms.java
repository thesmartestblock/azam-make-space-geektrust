package com.example.geektrust.Service;

import java.util.List;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.NoRoomsException;

public class VacantRooms implements IVacantRooms {

    private final List<MeetingRoom> rooms;

    public VacantRooms(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    public String checkVacancy(Slot slot) throws NoRoomsException {
        StringBuilder sb = new StringBuilder();

            for (MeetingRoom room : rooms) {
                if (room.availableSlot(slot))
                    sb.append(room.getRoomName()).append(" ");
            }

        if(sb.length()==0){
            throw new NoRoomsException();
        }
        return sb.toString().trim();
    }
}
