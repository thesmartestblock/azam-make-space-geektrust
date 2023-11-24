package com.example.geektrust.Service;

import com.example.geektrust.DTO.Booking;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;
import com.example.geektrust.Repositories.IRepository;

public class VacantRoomsService implements IVacantRoomsService {
    private final IRepository repo;

    public VacantRoomsService(IRepository repo) {
        this.repo = repo;
    }

    public void checkVacancy(Booking check) throws NoRoomsException {
        System.out.println(repo.checkVacancy(check));
    }
}
