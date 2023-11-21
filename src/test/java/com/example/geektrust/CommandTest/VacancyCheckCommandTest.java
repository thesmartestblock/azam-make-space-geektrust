package com.example.geektrust.CommandTest;

        import com.example.geektrust.Commands.BookRoomCommand;
        import com.example.geektrust.Commands.VacancyCheckCommand;
        import com.example.geektrust.DTO.Slot;
        import com.example.geektrust.Exceptions.InvalidInputException;
        import com.example.geektrust.Exceptions.NoRoomsException;
        import com.example.geektrust.Service.IService;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;

        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;
        import java.time.LocalTime;
        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.*;
public class VacancyCheckCommandTest {

    private VacancyCheckCommand vacancyCheckCommand;
    private IService service;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        service = mock(IService.class); // Mock the service
        vacancyCheckCommand = new VacancyCheckCommand(service);
    }

    @Test
    void execute() throws InvalidInputException, NoRoomsException {
        // Arrange
        List<String> tokens = new ArrayList<>();
        tokens.add("VACANCY");
        tokens.add("09:30");
        tokens.add("11:00");
        tokens.add("10");

        Slot newSlot = new Slot(LocalTime.parse(tokens.get(1)), LocalTime.parse(tokens.get(2)));
        newSlot.isValidTimeCheck();
        String expectedOutput = "C-Cave D-Tower G-Mansion\r\n";
        when(service.checkVacancy(newSlot)).thenReturn("C-Cave D-Tower G-Mansion");


        // Act
        vacancyCheckCommand.execute(tokens);

        // Assert
        assertEquals(expectedOutput,outputStreamCaptor.toString());
        verify(service).checkVacancy(eq(newSlot));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
