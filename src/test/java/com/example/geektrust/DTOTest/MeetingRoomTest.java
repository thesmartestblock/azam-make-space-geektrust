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
    void meetingRoomTest() throws InvalidInputException {
        Slot test1= new Slot(LocalTime.parse("09:30"),LocalTime.parse("10:00"));
        String meetingRoomExpected = "C-Cave";
        Assert.assertEquals(meetingRoom.getRoomName(),meetingRoomExpected);
        Assert.assertTrue(meetingRoom.getCapacity() == 3);
        Assert.assertTrue(meetingRoom.reserveSlot(test1,2));
        Assert.assertFalse(meetingRoom.reserveSlot(test1,4));
    }

}
