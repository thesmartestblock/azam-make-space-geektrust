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
            int startTimeIndex = 1;
            int endTimeIndex = 2;
            Slot check = new Slot(LocalTime.parse(tokens.get(startTimeIndex)), LocalTime.parse(tokens.get(endTimeIndex)));
            check.isValidTimeCheck();
            String vacancy = service.checkVacancy(check);
            System.out.println(vacancy);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
