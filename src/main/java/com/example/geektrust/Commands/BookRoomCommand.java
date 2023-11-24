package com.example.geektrust.Commands;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Service.IService;
import com.example.geektrust.Service.OfficeService;

import java.util.List;

public class BookRoomCommand implements ICommand {

    private final IService service;

    public BookRoomCommand(IService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            int startIndex=1;
            int endIndex=2;
            int capacityIndex=3;
            Booking booking = new Booking();
            booking.parse(tokens.get(startIndex), tokens.get(endIndex));
            booking.setCapacity(tokens.get(capacityIndex));
            service.bookRoom(booking);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
