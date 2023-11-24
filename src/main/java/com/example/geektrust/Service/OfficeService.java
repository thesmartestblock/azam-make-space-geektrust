package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

public class OfficeService implements IService {
    private final IRoomBookingService roomBooking;
    private final IVacantRoomsService vacantRooms;

    public OfficeService(IRoomBookingService roomBooking, IVacantRoomsService vacantRooms) {
        this.roomBooking = roomBooking;
        this.vacantRooms = vacantRooms;
    }

    public void bookRoom(Booking newBooking) throws InvalidInputException, NoRoomsException {
        roomBooking.bookRoom(newBooking);
    }

    public void checkVacancy(Booking check) throws NoRoomsException, InvalidInputException {
        vacantRooms.checkVacancy(check);
    }
}
