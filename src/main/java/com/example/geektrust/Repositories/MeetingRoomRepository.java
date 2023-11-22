package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class MeetingRoomRepository implements IRepository{

    private final List<MeetingRoom> rooms;

    public MeetingRoomRepository(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    public String allocateRoom(Slot newSlot, int capacity) throws NoRoomsException {
        for(MeetingRoom room : rooms){
            if(room.bookRoom(newSlot,capacity)){
                return room.getRoomName();
            }
        }
        throw new NoRoomsException();
    }
    public String checkVacancy(Slot slot) throws NoRoomsException {
        StringBuilder sb = new StringBuilder();
        for (MeetingRoom room : rooms) {
            if (room.isVacant(slot))
                sb.append(room.getRoomName()).append(" ");
        }
        String res = sb.toString().trim();
        if(res.isEmpty()) throw new NoRoomsException();
        return res;
    }
}
