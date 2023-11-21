package com.example.geektrust.Commands;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Service.TimeService;
import com.example.geektrust.Service.IService;

import java.time.LocalTime;
import java.util.List;

public class BookRoomCommand implements ICommand{

    private final IService service;

    public BookRoomCommand(IService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            int startTimeIndex = 1;
            int endTimeIndex = 2;
            Slot newSlot = new Slot(LocalTime.parse(tokens.get(startTimeIndex)), LocalTime.parse(tokens.get(endTimeIndex)));
            TimeService.inBufferTime(newSlot);
            int capacityIndex = 3;
            int capacity = Integer.parseInt(tokens.get(capacityIndex));
            String roomAllocated = service.bookRoom(newSlot, capacity);
            System.out.println(roomAllocated);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
