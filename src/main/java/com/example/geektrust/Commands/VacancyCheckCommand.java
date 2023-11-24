package com.example.geektrust.Commands;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Service.IService;
import com.example.geektrust.Service.OfficeService;

import java.util.List;

public class VacancyCheckCommand implements ICommand{
    private final IService service;

    public VacancyCheckCommand(IService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            int startIndex=1;
            int endIndex=2;
            Booking check = new Booking().parse(tokens.get(startIndex), tokens.get(endIndex));
            service.checkVacancy(check);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
