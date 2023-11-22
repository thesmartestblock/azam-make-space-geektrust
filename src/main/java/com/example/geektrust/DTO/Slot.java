package com.example.geektrust.DTO;

import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Slot implements Comparable<Slot>{

    private LocalTime start;
    private LocalTime end;

    public Slot(LocalTime start, LocalTime end) throws InvalidInputException {
        validTime(start, end);
        this.start = start;
        this.end = end;
    }

    private static void validTime(LocalTime start, LocalTime end) throws InvalidInputException {
        int minDivisor = 15;
        if (start.isAfter(end))
            throw new InvalidInputException();

        if (start.getMinute() % minDivisor != 0)
            throw new InvalidInputException();

        if (end.getMinute() % minDivisor != 0) {
            throw new InvalidInputException();
        }
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slot)) return false;
        Slot slot = (Slot) o;
        return Objects.equals(getStart(), slot.getStart()) && Objects.equals(getEnd(), slot.getEnd());
    }

    @Override
    public int compareTo(Slot otherSlot) {
        // Compare based on start times
        int startComparison = this.getStart().compareTo(otherSlot.getStart());

        // If start times are equal, compare based on end times
        if (startComparison == 0) {
            return this.getEnd().compareTo(otherSlot.getEnd());
        }

        return startComparison;
    }
}
