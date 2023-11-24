package com.example.geektrust.Repositories;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.List;

public class OfficeRepository implements IRepository {
    private final IBookingRepo bookingRepo;

    private final IVacantRoomRepo vacantRoomRepo;

    public OfficeRepository(IBookingRepo bookingRepo, IVacantRoomRepo vacantRoomRepo) {
        this.bookingRepo=bookingRepo;
        this.vacantRoomRepo=vacantRoomRepo;
    }

    @Override
    public String allocateRoom(Booking newBooking) throws NoRoomsException {
        return bookingRepo.allocateRoom(newBooking);
    }

    @Override
    public String checkVacancy(Booking check) throws NoRoomsException {
        return vacantRoomRepo.checkVacancy(check);
    }

}
