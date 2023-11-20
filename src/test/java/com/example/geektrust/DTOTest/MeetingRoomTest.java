package com.example.geektrust.DTOTest;

import com.example.geektrust.DTO.MeetingRoom;
import com.example.geektrust.DTO.Slot;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class MeetingRoomTest {
    MeetingRoom room1;
    @BeforeEach
    void setup(){
        room1 = new MeetingRoom(3,"C-Cave");
    }
    @Test
    public void bookRoom(){
        Slot s1 = new Slot(LocalTime.of(9,30),LocalTime.of(12,0));
        Assert.assertTrue(room1.reserveSlot(s1,3));
        Assert.assertFalse(room1.reserveSlot(s1,13));
    }
    @Test
    public void vacantRooms(){
        Slot s1 = new Slot(LocalTime.of(9,30),LocalTime.of(12,0));
        Assert.assertTrue(room1.availableSlot(s1));
        room1.reserveSlot(s1,2);
        Assert.assertFalse(room1.availableSlot(s1));
    }
    @Test
    public void miscellenousTest(){
        Assert.assertEquals("C-Cave",room1.getRoomName());
        Assert.assertEquals(3,room1.getCapacity());
    }
}
