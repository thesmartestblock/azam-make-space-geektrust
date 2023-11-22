package com.example.geektrust.DTO;

import java.util.Iterator;
import java.util.TreeSet;

public class MeetingRoom {

    private final int capacity;
    private final String roomName;

    // Use a TreeSet with a custom comparator to maintain meetings in sorted order
    private final TreeSet<Slot> repo;

    public MeetingRoom(int capacity, String roomName) {
        this.capacity = capacity;
        this.roomName = roomName;

        // Custom comparator to sort meetings based on start time and then end time
        this.repo = new TreeSet<>((s1, s2) -> {
            if (s1.getStart().equals(s2.getStart())) {
                return s1.getEnd().compareTo(s2.getEnd());
            }
            return s1.getStart().compareTo(s2.getStart());
        });
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

    // Check if a room has a vacant slot for a given meeting
    public String hasVacantRoom(Slot check) {
        if (availableSlot(check)) {
            return roomName;
        }
        return "";
    }

    // Check if the room has an available slot for the given meeting
    public boolean availableSlot(Slot check) {
        if (repo.isEmpty()) {
            return true;
        }

        // Temporarily add the meeting to check for availability
        repo.add(check);

        Iterator<Slot> iterator = repo.iterator();
        Slot s1 = iterator.next();

        while (iterator.hasNext()) {
            Slot s2 = iterator.next();
            if (s2.getStart().isBefore(s1.getEnd())) {
                // Overlapping meetings found, remove the temporarily added meeting
                repo.remove(check);
                return false;
            }
            s1 = s2;
        }

        // Remove the temporarily added meeting
        repo.remove(check);

        return true;
    }
}
