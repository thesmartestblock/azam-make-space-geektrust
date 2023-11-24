package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class VacantRoomRepo implements IVacantRoomRepo{
    private final List<MeetingOffice> offices;

    public VacantRoomRepo(List<MeetingOffice> offices) {
        this.offices = offices;
    }
    @Override
    public String checkVacancy(Booking booking) throws NoRoomsException {
        StringBuilder sb = new StringBuilder();
        for (MeetingOffice office : offices) {
            if (office.isVacant(booking)) {
                sb.append(office.getRoomName()).append(" ");
            }
        }
        String res = sb.toString().trim();
        if (res.isEmpty()) throw new NoRoomsException();
        return res;
    }
}
