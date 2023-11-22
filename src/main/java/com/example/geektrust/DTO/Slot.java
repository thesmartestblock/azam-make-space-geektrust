package com.example.geektrust.DTO;

import com.example.geektrust.Exceptions.InvalidInputException;

import java.time.LocalTime;
import java.util.Objects;

public class Slot {

    private final LocalTime start;
    private final LocalTime end;

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

    public boolean hasOverlap(Slot newSlot) {
        Slot s1 = compareTo(newSlot) ? this : newSlot;
        Slot s2 = !compareTo(newSlot) ? this : newSlot;
        return s1.getEnd().isAfter(s2.getStart());
    }

    public boolean compareTo(Slot newSlot) {
        if (this.getStart().equals(newSlot.getStart())) {
            return this.getEnd().isBefore(newSlot.getEnd());
        }

        return this.getStart().isBefore(newSlot.getStart());
    }
}
