package com.example.geektrust.DTO;

import java.util.ArrayList;
import java.util.List;

public class MeetingOffice {
    private final int capacity;
    private final String roomName;
    private final List<Booking> repo;

    public MeetingOffice(int capacity, String roomName) {
        this.capacity = capacity;
        this.roomName = roomName;
        this.repo = new ArrayList<>();
    }
    public String getRoomName() {
        return roomName;
    }

    public boolean isVacant(Booking check) {
        return repo.stream().noneMatch((s) -> s.isOverlap(check));
    }

    public boolean bookRoom(Booking newBooking) {
        if (this.capacity < newBooking.getCapacity()) {
            return false;
        }
        if (isVacant(newBooking)) return repo.add(newBooking);
        return false;
    }
}
