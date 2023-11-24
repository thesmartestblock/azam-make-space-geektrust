package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.ArrayList;
import java.util.List;

public class OfficeService implements IService {
    private final IRoomBookingService roomBooking;
    private final IVacantRoomsService vacantRooms;

    public OfficeService(IRoomBookingService roomBooking, IVacantRoomsService vacantRooms) {
        this.roomBooking = roomBooking;
        this.vacantRooms = vacantRooms;
    }

    private static void inBufferTime(Booking check) throws NoRoomsException, InvalidInputException {
        List<Booking> meetings = new ArrayList<>();
        meetings.add(new Booking().parse("09:00", "09:15"));
        meetings.add(new Booking().parse("13:15", "13:45"));
        meetings.add(new Booking().parse("18:45", "19:00"));

        if (meetings.stream().anyMatch(s -> s.isOverlap(check)))
            throw new NoRoomsException();
    }


    public void bookRoom(Booking newBooking) throws InvalidInputException, NoRoomsException {
        inBufferTime(newBooking);
        roomBooking.bookRoom(newBooking);
    }

    public void checkVacancy(Booking check) throws NoRoomsException, InvalidInputException {
        inBufferTime(check);
        vacantRooms.checkVacancy(check);
    }
}
