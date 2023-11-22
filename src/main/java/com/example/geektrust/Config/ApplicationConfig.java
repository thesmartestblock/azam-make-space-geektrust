package com.example.geektrust.Config;

import com.example.geektrust.Commands.BookRoomCommand;
import com.example.geektrust.Commands.ICommand;
import com.example.geektrust.Commands.VacancyCheckCommand;
import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.Repositories.IRepository;
import com.example.geektrust.Repositories.MeetingRoomRepository;
import com.example.geektrust.Service.*;

import java.util.Arrays;
import java.util.List;

public class ApplicationConfig {

    private static final MeetingRoom cCave = new MeetingRoom(3, "C-Cave");
    private static final MeetingRoom dTower = new MeetingRoom(7, "D-Tower");
    private static final MeetingRoom gMansion = new MeetingRoom(20, "G-Mansion");
    private static final List<MeetingRoom> rooms = Arrays.asList(cCave, dTower, gMansion);
    private static final IRepository repository = new MeetingRoomRepository(rooms);
    private static final IRoomBooking bookingService =  new RoomBookingService(repository);
    private static final IVacantRooms vacantRooms = new VacantRoomsService(repository);

    private static final IService service = new Service(bookingService,vacantRooms);
    private static final ICommand bookingCommand = new BookRoomCommand(service);
    private static final ICommand vacantCheckCommand = new VacancyCheckCommand(service);

    private static final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.registerCommand("BOOK", bookingCommand);
        commandInvoker.registerCommand("VACANCY", vacantCheckCommand);

        return commandInvoker;
    }

}
