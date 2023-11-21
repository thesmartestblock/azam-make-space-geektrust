package com.example.geektrust.DTOTest;

import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

@DisplayName("Test")
public class SlotTest {

    @Test
    void shouldThrowErrorAndoverrlap() throws InvalidInputException {
        Slot test1 = new Slot(LocalTime.parse("09:00"),LocalTime.parse("10:00"));
        Slot test2 = new Slot(LocalTime.parse("10:00"),LocalTime.parse("10:30"));

        Assertions.assertThrows(InvalidInputException.class, ()-> new Slot(LocalTime.parse("13:00"),LocalTime.parse("12:00")));


    }
}
