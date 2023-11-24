package com.example.geektrust.DTO;

import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

public class Booking {
    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public Booking parse(String start, String end) throws InvalidInputException {

        String[] s = start.split(":");
        startHour = Integer.parseInt(s[0]);
        startMin = Integer.parseInt(s[1]);
        String[] e = end.split(":");
        endHour = Integer.parseInt(e[0]);
        endMin = Integer.parseInt(e[1]);
        validTime(startHour,startMin);
        validTime(endHour,endMin);
        validTime(startHour,startMin,endHour,endMin);
        return this;
    }

    private void validTime(int startHour, int startMin, int endHour, int endMin) throws InvalidInputException {
        if((startHour==endHour && startMin>endMin)|| startHour>endHour)
            throw new InvalidInputException();


    }

    public void setCapacity(String seats) throws NoRoomsException {
        this.capacity=Integer.parseInt(seats);
        if(capacity<2||capacity>20)
            throw new NoRoomsException();
    }


    private void validTime(int hour, int min) throws InvalidInputException {
        if(hour<0||hour>23)
            throw new InvalidInputException();
        if(min<0||min>45||min%15!=0)
            throw new InvalidInputException();
    }


    public boolean isOverlap(Booking check) {
        return (startHour < check.endHour || (startHour == check.endHour && startMin < check.endMin))
                && (endHour > check.startHour || (endHour == check.startHour && endMin > check.startMin));

    }

}
