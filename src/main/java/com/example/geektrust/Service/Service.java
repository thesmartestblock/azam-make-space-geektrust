package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;

public class Service implements IService{

    private IRoomBooking roomBooking;
    private IVacantRooms vacantRooms;

    public Service(IRoomBooking roomBooking, IVacantRooms vacantRooms) {
        this.roomBooking = roomBooking;
        this.vacantRooms = vacantRooms;
    }

    @Override
    public String bookRoom(Slot newSlot, int capacity) {
        return roomBooking.bookRoom(newSlot,capacity);
    }

    @Override
    public String checkVacancy(Slot slot) {
        return vacantRooms.checkVacancy(slot);
    }
}
