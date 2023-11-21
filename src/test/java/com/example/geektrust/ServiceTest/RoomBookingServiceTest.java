package com.example.geektrust.ServiceTest;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;
import com.example.geektrust.Service.RoomBookingService;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class RoomBookingServiceTest {

    RoomBookingService roomBookingService;

    @BeforeEach
    void setup(){
        List<MeetingRoom> rooms = Arrays.asList(new MeetingRoom(3,"C-Cave"),new MeetingRoom(7,"D-Tower"), new MeetingRoom(20,"G-Mansion"));
        roomBookingService = new RoomBookingService(rooms);
    }
    @Test
    public void edgeCasesOfRoomBookingService() throws InvalidInputException, NoRoomsException {
        Slot test1=new Slot(LocalTime.parse("09:00"),LocalTime.parse("10:30"));
        Slot test2=new Slot(LocalTime.parse("09:30"),LocalTime.parse("10:30"));
        Assertions.assertThrows(NoRoomsException.class,()->roomBookingService.bookRoom(test1,3));
        Assert.assertEquals("D-Tower",roomBookingService.bookRoom(test2,5));
    }
}
