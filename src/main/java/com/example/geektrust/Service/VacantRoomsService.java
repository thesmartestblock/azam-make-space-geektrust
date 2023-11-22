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
    }
}
