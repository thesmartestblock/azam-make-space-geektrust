package com.example.geektrust.Commands;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Service.IService;

import java.time.LocalTime;
import java.util.List;

public class VacancyCheckCommand implements ICommand{
    private final IService service;

    public VacancyCheckCommand(IService service) {
        this.service = service;
    }
    @Override
    public void execute(List<String> tokens) {
        try {
            Slot check = new Slot(LocalTime.parse(tokens.get(1)), LocalTime.parse(tokens.get(2)));
            check.isValidTimeCheck();
            String vacancy = service.checkVacancy(check);
            System.out.println(vacancy);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
