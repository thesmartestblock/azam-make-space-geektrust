package com.example.geektrust.DTO;

import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;
    private int capacity;

    public Booking() {
    }

    private Booking(String start, String end) {
        parseTime(start, end);
    }

    public int getCapacity() {
        return capacity;
    }

    public Booking parse(String start, String end) throws InvalidInputException, NoRoomsException {
        parseTime(start, end);
        validTime(startHour, startMin, endHour, endMin);
        validTime(startHour,startMin);
        validTime(endHour,endMin);
        checkBuffer();
        return this;
    }

    private void parseTime(String start, String end) {
        int hourIndex=0;
        int minIndex=1;
        String[] s = start.split(":");
        startHour = Integer.parseInt(s[hourIndex]);
        startMin = Integer.parseInt(s[minIndex]);
        String[] e = end.split(":");
        endHour = Integer.parseInt(e[hourIndex]);
        endMin = Integer.parseInt(e[minIndex]);
    }

    private void validTime(int startHour, int startMin, int endHour, int endMin) throws InvalidInputException {
        if (isInvalidTimeRange(startHour, startMin, endHour, endMin))
            throw new InvalidInputException();
    }

    private boolean isInvalidTimeRange(int startHour, int startMin, int endHour, int endMin) {
        return (startHour == endHour && startMin > endMin) || startHour > endHour;
    }

    private void checkBuffer() throws NoRoomsException {
        List<Booking> buffers = createBuffers();
        if (buffers.stream().anyMatch(s -> s.isOverlap(this)))
            throw new NoRoomsException();
    }

    private List<Booking> createBuffers() {
        List<Booking> buffers = new ArrayList<>();
        buffers.add(new Booking("09:00", "09:15"));
        buffers.add(new Booking("13:15", "13:45"));
        buffers.add(new Booking("18:45", "19:00"));
        return buffers;
    }

    public void setCapacity(String seats) throws NoRoomsException {
        this.capacity = Integer.parseInt(seats);
        if (isInvalidCapacity())
            throw new NoRoomsException();
    }

    private boolean isInvalidCapacity() {
        int minCapacity = 2;
        int maxCapacity = 20;
        return capacity < minCapacity || capacity > maxCapacity;
    }

    private void validTime(int hour, int min) throws InvalidInputException {
        if (isInvalidHour(hour) || isInvalidMinute(min))
            throw new InvalidInputException();
    }

    private boolean isInvalidHour(int hour) {
        int minHours = 0;
        int maxHours = 23;
        return hour < minHours || hour > maxHours;
    }

    private boolean isInvalidMinute(int min) {
        int minDivisor = 15;
        int minMinutes = 0;
        int maxMinutes = 45;
        return min < minMinutes || min > maxMinutes || min % minDivisor != 0;
    }

    public boolean isOverlap(Booking check) {
        return (startHour < check.endHour || (startHour == check.endHour && startMin < check.endMin))
                && (endHour > check.startHour || (endHour == check.startHour && endMin > check.startMin));
    }
}
