package com.example.geektrust.Services;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Strategy.FirstComeFirstServe;
import com.example.geektrust.Strategy.RoomBookingStrategy;
import com.example.geektrust.Strategy.VacanctRooms;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomService {

    private static RoomBookingStrategy bookingStrategy;

    private MeetingRoom cCave;
    private MeetingRoom dTower;
    private MeetingRoom gMansion;

    private static VacanctRooms vacanctRooms;

    public MeetingRoomService() {
        this.cCave = new MeetingRoom(3, "C-Cave");
        this.dTower = new MeetingRoom(7, "D-Tower");
        this.gMansion = new MeetingRoom(20, "G-Mansion");
        List<MeetingRoom> rooms = Arrays.asList(cCave, dTower, gMansion);
        this.bookingStrategy = new FirstComeFirstServe(rooms);
        this.vacanctRooms = new VacanctRooms(rooms);
    }

    public void bookMeetingRoom(List<String> tokens) {
        try {
            String[] start1 = tokens.get(1).split(":");
            String[] end1 = tokens.get(2).split(":");
            Slot newSlot = new Slot(LocalTime.of(Integer.parseInt(start1[0]), Integer.parseInt(start1[1])), LocalTime.of(Integer.parseInt(end1[0]), Integer.parseInt(end1[1])));
            newSlot.isValidTimeCheck();
            int capacity = Integer.parseInt(tokens.get(3));
            String roomAllocated = bookingStrategy.BookRoom(newSlot, capacity);
            System.out.println(roomAllocated);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void vacancyCheck(List<String> tokens) {
        try {
            Slot check = new Slot(LocalTime.parse(tokens.get(1)), LocalTime.parse(tokens.get(2)));
            String vacancy = vacanctRooms.checkVacancy(check);
            System.out.println(vacancy);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
