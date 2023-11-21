package com.example.geektrust.CommandTest;

import com.example.geektrust.Commands.BookRoomCommand;
import com.example.geektrust.DTO.Slot;
import com.example.geektrust.Service.TimeService;
import com.example.geektrust.Exceptions.InvalidInputException;
import com.example.geektrust.Exceptions.NoRoomsException;
import com.example.geektrust.Service.IService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class BookingCommandTest {

    private BookRoomCommand bookRoomCommand;

    private IService service;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        service = mock(IService.class); // Mock the service
        bookRoomCommand = new BookRoomCommand(service);
    }

    @Test
    void execute() throws InvalidInputException, NoRoomsException {
        // Arrange
        List<String> tokens = new ArrayList<>();
        tokens.add("BOOK");
        tokens.add("09:30");
        tokens.add("11:00");
        tokens.add("10");

        Slot newSlot = new Slot(LocalTime.parse(tokens.get(1)), LocalTime.parse(tokens.get(2)));
        TimeService.inBufferTime(newSlot);
        int capacity = Integer.parseInt(tokens.get(3));
        String expectedOutput = "D-Tower\r\n";
        when(service.bookRoom(newSlot,capacity)).thenReturn("D-Tower");


        // Act
        bookRoomCommand.execute(tokens);

        // Assert
//        assertEquals(expectedOutput,outputStreamCaptor.toString());
        verify(service).bookRoom(eq(newSlot), eq(capacity));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
