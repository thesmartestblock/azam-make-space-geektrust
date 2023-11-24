package com.example.geektrust.Commands;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Service.OfficeService;

import java.util.List;

public class VacancyCheckCommand implements ICommand{
    private final OfficeService service;

    public VacancyCheckCommand(OfficeService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            Booking check = new Booking().parse(tokens.get(1), tokens.get(2));
            service.checkVacancy(check);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
