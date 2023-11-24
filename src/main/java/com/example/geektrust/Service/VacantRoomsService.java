package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class VacantRoomsService implements IVacantRoomsService {
    private final List<MeetingOffice> offices;

    public VacantRoomsService(List<MeetingOffice> offices) {
        this.offices = offices;
    }

    public void checkVacancy(Booking check) throws NoRoomsException {
        StringBuilder sb = new StringBuilder();
        for (MeetingOffice office : offices) {
            if (office.isVacant(check)) {
                sb.append(office.getRoomName()).append(" ");
            }
        }
        String res = sb.toString().trim();
        if (res.isEmpty()) throw new NoRoomsException();
        System.out.println(res);
    }
}
