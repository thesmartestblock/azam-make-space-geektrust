package com.example.geektrust.DTO;

import java.util.Comparator;
import java.util.TreeSet;

public class MeetingRoom {

    private final int capacity;
    private final String roomName;
    private final TreeSet<Slot> repo;

    public MeetingRoom(int capacity, String roomName) {
        this.capacity = capacity;
        this.roomName = roomName;
        this.repo = new TreeSet<>(Comparator.comparing(Slot::getStart));
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean availableSlot(Slot check){
        return repo.stream().noneMatch((s1) -> s1.isOverlapping(check));
    }

    public boolean reserveSlot(Slot slot, int seats) {
        if (capacity < seats) {
            return false;
        }
        if (availableSlot(slot) ) {
            return  repo.add(slot);
        }
        return false;
    }

}
