package com.example.geektrust.DTO;

import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.time.LocalTime;
import java.util.Objects;

public class Slot {

    private LocalTime start;
    private LocalTime end;

    public Slot(LocalTime start, LocalTime end) throws InvalidInputException {
        validTime(start, end);
        this.start = start;
        this.end = end;
    }

    private static void validTime(LocalTime start, LocalTime end) throws InvalidInputException {
        int minDivisor = 15;
        if (start.isAfter(end) || start.getMinute() % minDivisor != 0 || end.getMinute() % minDivisor != 0) {
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Slot other = (Slot) obj;
        if (start == null) {
            if (other.start != null)
                return false;
        } else if (!start.equals(other.start))
            return false;
        if (end == null) {
            return other.end == null;
        } else if (!end.equals(other.end))
            return false;
        return true;
    }

    public boolean isOverlapping(Slot check){
        try {
            startOverlapping(check);
            endOverlapping(check);
            completeOverlap(check);
            subsetOverlap(check);
            theEqualStartEnd(check);
            return false;
        }
        catch (NoRoomsException e) {
            return true;
        }
    }
    public void inBufferTime(Slot check) throws NoRoomsException {
            startOverlapping(check);
            endOverlapping(check);
            completeOverlap(check);
            subsetOverlap(check);
            theEqualStartEnd(check);
    }
    private void startOverlapping(Slot check) throws NoRoomsException {
        if(start.isBefore(check.getStart()) && end.isAfter(check.getStart()))
            throw new NoRoomsException();
    }
    private void endOverlapping(Slot check) throws NoRoomsException {
        if(start.isBefore(check.getEnd()) && end.isAfter(check.getEnd()))
            throw new NoRoomsException();
    }
    private void completeOverlap(Slot check) throws NoRoomsException {
        if(start.isBefore(check.getStart()) && end.isAfter(check.getEnd()))
            throw new NoRoomsException();
    }

    private void subsetOverlap(Slot check) throws NoRoomsException {
        if(check.getStart().isBefore(start) && check.getEnd().isAfter(end))
            throw new NoRoomsException();
    }
    private void theEqualStartEnd(Slot check) throws NoRoomsException {
        if(check.getStart().equals(start) || check.getEnd().equals(end))
            throw new NoRoomsException();
    }
    public void isValidTimeCheck() throws NoRoomsException, InvalidInputException {

        int lastPermittedTimeHour = 23;
        int lastPermittedTimeMinute = 45;
        LocalTime lastPermittedTime = LocalTime.of(lastPermittedTimeHour, lastPermittedTimeMinute);

        if (this.end.isAfter(lastPermittedTime)) {
            throw new NoRoomsException();

        }

        Slot[] bufferTimes = {
                new Slot(LocalTime.parse("09:00"), LocalTime.parse("09:15")),
                new Slot(LocalTime.parse("13:15"), LocalTime.parse("13:45")),
                new Slot(LocalTime.parse("18:45"), LocalTime.parse("19:00"))
        };

        for (Slot bufferTime : bufferTimes) {
            bufferTime.inBufferTime(this);
        }

    }

}
