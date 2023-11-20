package com.example.geektrust.DTO;

import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.time.LocalTime;
import java.util.Objects;

public class Slot {

    LocalTime start;
    LocalTime end;

    public Slot(LocalTime start, LocalTime end) throws InvalidInputException {
        validtime(start, end);
        this.start = start;
        this.end = end;
    }

    private static void validtime(LocalTime start, LocalTime end) throws InvalidInputException {
        if (start.isAfter(end) || start.getMinute() % 15 != 0 || end.getMinute() % 15 != 0) {
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

    public boolean isOverlapping(Slot check) {
        return startOverlapping(check) || endOverlapping(check) || completeOverlap(check) || subsetOverlap(check) || theEqualStartEnd(check);
    }
    private boolean startOverlapping(Slot check){
        return start.isBefore(check.getStart()) && end.isAfter(check.getStart());
    }
    private boolean endOverlapping(Slot check){
        return start.isBefore(check.getEnd()) && end.isAfter(check.getEnd());
    }
    private boolean completeOverlap(Slot check){
        return start.isBefore(check.getStart()) && end.isAfter(check.getEnd());
    }

    private boolean subsetOverlap(Slot check){
        return check.getStart().isBefore(start) && check.getEnd().isAfter(end);
    }
    private boolean theEqualStartEnd(Slot check){
        return check.getStart().equals(start) || check.getEnd().equals(end);
    }
    public void isValidTimeCheck() throws NoRoomsException, InvalidInputException {

        int lastPermittedTimeHour = 23;
        int lastPermittedTimeMinute = 45;
        LocalTime lastPermittedTime = LocalTime.of(lastPermittedTimeHour, lastPermittedTimeMinute);

        if (this.end.isAfter(lastPermittedTime)) {
            throw new NoRoomsException();

        }

        Slot bufferTime1 = new Slot(LocalTime.parse("09:00"), LocalTime.parse("09:15"));
        Slot bufferTime2 = new Slot(LocalTime.parse("13:15"), LocalTime.parse("13:45"));
        Slot bufferTime3 = new Slot(LocalTime.parse("18:45"), LocalTime.parse("19:00"));

        if (bufferTime1.isOverlapping(this) || bufferTime2.isOverlapping(this) || bufferTime3.isOverlapping(this))
            throw new NoRoomsException();

    }

}
