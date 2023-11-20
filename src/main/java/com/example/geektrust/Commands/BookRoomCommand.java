package com.example.geektrust.Commands;

import com.example.geektrust.DTO.Slot;
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
            Slot newSlot = new Slot(LocalTime.parse(tokens.get(1)), LocalTime.parse(tokens.get(2)));
            newSlot.isValidTimeCheck();
            int capacity = Integer.parseInt(tokens.get(3));
            String roomAllocated = service.bookRoom(newSlot, capacity);
            System.out.println(roomAllocated);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
