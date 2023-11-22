package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Service implements IService{

    private final IRoomBooking roomBooking;
    private final IVacantRooms vacantRooms;

    public Service(IRoomBooking roomBooking, IVacantRooms vacantRooms) {
        this.roomBooking = roomBooking;
        this.vacantRooms = vacantRooms;
    }

    @Override
    public String bookRoom(Slot newSlot, int capacity) throws InvalidInputException, NoRoomsException {
        inBufferTime(newSlot);
        return roomBooking.bookRoom(newSlot,capacity);
    }

    @Override
    public String checkVacancy(Slot slot) throws NoRoomsException, InvalidInputException {
        inBufferTime(slot);
        return vacantRooms.checkVacancy(slot);
    }

    private static void inBufferTime(Slot check) throws NoRoomsException, InvalidInputException {
        List<Slot> meetings = new ArrayList<>();
        meetings.add(new Slot(LocalTime.parse("09:00"), LocalTime.parse("09:15")));
        meetings.add(new Slot(LocalTime.parse("13:15"), LocalTime.parse("13:45")));
        meetings.add(new Slot(LocalTime.parse("18:45"), LocalTime.parse("19:00")));

        meetings.add(check);
        meetings.sort(Comparator.comparing(Slot::getStart));

//        for (int i = 1; i < meetings.size(); i++) {
//            if (meetings.get(i).getStart().isBefore(meetings.get(i - 1).getEnd())) {
//                // Overlapping meetings found
//                throw new NoRoomsException();
//            }
//        }
    }
}
