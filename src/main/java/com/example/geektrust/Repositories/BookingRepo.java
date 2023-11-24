package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class BookingRepo implements IBookingRepo{
    private final List<MeetingOffice> offices;

    public BookingRepo(List<MeetingOffice> offices) {
        this.offices = offices;
    }

    @Override
    public String allocateRoom(Booking booking) throws NoRoomsException {
        for (MeetingOffice office : offices) {
            if (office.bookRoom(booking)) {
                return office.getRoomName();
            }
        }
        throw new NoRoomsException();
    }
}
