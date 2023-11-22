package com.example.geektrust.DTO;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class MeetingRoom {

    private final int capacity;
    private final String roomName;
    private final TreeSet<Slot> repo;

    public MeetingRoom(int capacity, String roomName) {
        this.capacity = capacity;
        this.roomName = roomName;
        this.repo = new TreeSet<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomName() {
        return roomName;
    }

    public TreeSet<Slot> getRepo() {
        return repo;
    }

}
