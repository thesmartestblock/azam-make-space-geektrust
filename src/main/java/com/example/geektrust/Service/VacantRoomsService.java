package com.example.geektrust.Service;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.NoRoomsException;
import com.example.geektrust.Repositories.IRepository;

public class VacantRoomsService implements IVacantRooms {

    private final IRepository repository;

    public VacantRoomsService(IRepository repository) {
        this.repository = repository;
    }


    public String checkVacancy(Slot slot) throws NoRoomsException {
        return repository.checkVacancy(slot);
    }
}
