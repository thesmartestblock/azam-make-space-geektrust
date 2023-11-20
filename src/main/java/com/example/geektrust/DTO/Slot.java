package com.example.geektrust.DTO;

import java.time.LocalTime;

public class Slot {

    LocalTime start;
    LocalTime end;

    public Slot(LocalTime start, LocalTime end) {
        if (start.isAfter(end) || start.getMinute() % 15 != 0 || end.getMinute() % 15 != 0) {
            throw new IllegalArgumentException("INCORRECT_INPUT");
        }
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        return result;
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
    public void isValidTimeCheck() {

        LocalTime lastPermittedTime = LocalTime.of(23, 45);

        if (this.end.isAfter(lastPermittedTime)) {
            throw new IllegalArgumentException("INCORRECT_INPUT");

        }

        Slot bufferTime1 = new Slot(LocalTime.parse("09:00"), LocalTime.parse("09:15"));
        Slot bufferTime2 = new Slot(LocalTime.parse("13:15"), LocalTime.parse("13:45"));
        Slot bufferTime3 = new Slot(LocalTime.parse("18:45"), LocalTime.parse("19:00"));

        if (bufferTime1.isOverlapping(this) || bufferTime2.isOverlapping(this) || bufferTime3.isOverlapping(this))
            throw new IllegalArgumentException("INCORRECT_INPUT");

    }

    @Override
    public String toString() {
        return "Slot [start=" + start + ", end=" + end + "]";
    }

}
