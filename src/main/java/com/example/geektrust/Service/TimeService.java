package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimeService {

    public static boolean isOverlapping(List<Slot> meetings) {
        meetings.sort(Comparator.comparing(Slot::getStart));

        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).getStart().isBefore(meetings.get(i - 1).getEnd())) {
                // Overlapping meetings found
                return true;
            }
        }
        return false;
    }

    public static void inBufferTime(Slot check) throws NoRoomsException, InvalidInputException {
        List<Slot> meetings = new ArrayList<>();
        meetings.add(new Slot(LocalTime.parse("09:00"), LocalTime.parse("09:15")));
        meetings.add(new Slot(LocalTime.parse("13:15"), LocalTime.parse("13:45")));
        meetings.add(new Slot(LocalTime.parse("18:45"), LocalTime.parse("19:00")));

        meetings.add(check);
        meetings.sort(Comparator.comparing(Slot::getStart));

        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).getStart().isBefore(meetings.get(i - 1).getEnd())) {
                // Overlapping meetings found
                throw new NoRoomsException();
            }
        }
    }

}
