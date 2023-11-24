package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class RoomBookingService implements IRoomBookingService {
    private final List<MeetingOffice> offices;

    public RoomBookingService(List<MeetingOffice> offices) {
        this.offices = offices;
    }

    public void bookRoom(Booking newBooking) throws NoRoomsException {
        for (MeetingOffice office : offices) {
            if (office.bookRoom(newBooking)) {
                System.out.println(office.getRoomName());
                return;
            }
        }
        throw new NoRoomsException();
    }
}