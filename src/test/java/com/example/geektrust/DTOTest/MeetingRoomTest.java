package com.example.geektrust.DTOTest;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class MeetingRoomTest {

    MeetingRoom meetingRoom;

    @BeforeEach
    void setup(){
        meetingRoom = new MeetingRoom(3,"C-Cave");
    }
    @Test
    void shouldThrowAndPassBasicTest() throws InvalidInputException {
        Slot test1= new Slot(LocalTime.parse("09:30"),LocalTime.parse("10:00"));
        String meetingRoomExpected = "C-Cave";
        Assert.assertEquals(meetingRoom.getRoomName(),meetingRoomExpected);
        Assert.assertEquals(3, meetingRoom.getCapacity());
    }

}
