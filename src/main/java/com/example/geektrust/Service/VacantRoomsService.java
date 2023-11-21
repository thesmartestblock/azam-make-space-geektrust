package com.example.geektrust.Service;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class VacantRoomsService implements IVacantRooms {

    private final List<MeetingRoom> rooms;

    public VacantRoomsService(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    public String checkVacancy(Slot slot) throws NoRoomsException {
        StringBuilder sb = new StringBuilder();

        for (MeetingRoom room : rooms) {
            if (room.availableSlot(slot))
                sb.append(room.getRoomName()).append(" ");
        }
        //java 8 doesnot support .isEmpty() method for stringbuilder
        String res = sb.toString().trim();
        if (res.isEmpty()) {
            throw new NoRoomsException();
        }
        return res;
    }
}