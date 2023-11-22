package com.example.geektrust.DTO;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {

    private final int capacity;
    private final String roomName;
    private final List<Slot> repo;


    public MeetingRoom(int capacity, String roomName) {
        this.capacity = capacity;
        this.roomName = roomName;
        this.repo = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isVacant(Slot newSlot) {
        return repo.stream().noneMatch((s) -> s.hasOverlap(newSlot));
    }

    public boolean bookRoom(Slot newSlot, int capacity) {
        if (this.capacity < capacity){
            return false;
        }
        if (isVacant(newSlot))
            return repo.add(newSlot);
        return false;
    }

}
