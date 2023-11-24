package com.example.geektrust.Config;

import com.example.geektrust.Commands.BookRoomCommand;
import com.example.geektrust.Commands.ICommand;
import com.example.geektrust.Commands.VacancyCheckCommand;
import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Repositories.IRepository;
import com.example.geektrust.Repositories.OfficeRepository;
import com.example.geektrust.Service.*;

import java.util.Arrays;
import java.util.List;

public class Config {

    private static final MeetingOffice cCave = new MeetingOffice(3, "C-Cave");
    private static final MeetingOffice dTower = new MeetingOffice(7, "D-Tower");
    private static final MeetingOffice gMansion = new MeetingOffice(20, "G-Mansion");
    private static final List<MeetingOffice> offices = Arrays.asList(cCave, dTower, gMansion);
    private static final CommandInvoker commandInvoker = new CommandInvoker();

    private static final IRepository officeRepository = new OfficeRepository(offices);
    private static final IRoomBookingService roomBookingService = new RoomBookingService(officeRepository);
    private static final IVacantRoomsService vacantRoomsService = new VacantRoomsService(officeRepository);

    private static final IService service = new OfficeService(roomBookingService, vacantRoomsService);
    private static final ICommand bookingCommand = new BookRoomCommand(service);
    private static final ICommand vacantCheckCommand = new VacancyCheckCommand(service);

    public CommandInvoker getCommandInvoker() {
        commandInvoker.registerCommand("BOOK", bookingCommand);
        commandInvoker.registerCommand("VACANCY", vacantCheckCommand);

        return commandInvoker;
    }

}
