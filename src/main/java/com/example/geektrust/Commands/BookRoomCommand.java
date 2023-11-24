package com.example.geektrust.Commands;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Service.OfficeService;

import java.util.List;

public class BookRoomCommand implements ICommand {

    private final OfficeService service;

    public BookRoomCommand(OfficeService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            Booking booking = new Booking();
            booking.parse(tokens.get(1), tokens.get(2));
            booking.setCapacity(tokens.get(3));
            service.bookRoom(booking);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
