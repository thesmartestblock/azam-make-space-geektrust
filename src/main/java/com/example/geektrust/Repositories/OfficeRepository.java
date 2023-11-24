package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class OfficeRepository implements IRepository {
    private final List<MeetingOffice> offices;

    public OfficeRepository(List<MeetingOffice> offices) {
        this.offices = offices;
    }

    @Override
    public String allocateRoom(Booking newBooking) throws NoRoomsException {
        for (MeetingOffice office : offices) {
            if (office.bookRoom(newBooking)) {
                return office.getRoomName();
            }
        }
        throw new NoRoomsException();
    }

    @Override
    public String checkVacancy(Booking check) throws NoRoomsException {
        StringBuilder sb = new StringBuilder();
        for (MeetingOffice office : offices) {
            if (office.isVacant(check)) {
                sb.append(office.getRoomName()).append(" ");
            }
        }
        String res = sb.toString().trim();
        if (res.isEmpty()) throw new NoRoomsException();
        return res;
    }

}
