package com.example.geektrust.DTOTest;

import com.example.geektrust.DTO.MeetingOffice;
import com.example.geektrust.Exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MeetingOfficeTest {

    MeetingOffice meetingOffice;

    @BeforeEach
    void setup(){
        meetingOffice = new MeetingOffice(3,"C-Cave");
    }
    @Test
    void shouldThrowAndPassBasicTest() throws InvalidInputException {
    }

}
