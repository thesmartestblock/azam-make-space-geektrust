package com.example.geektrust;

import com.example.geektrust.DTO.Slot;
import junit.framework.Assert;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

@DisplayName("Test")
public class MainTest {

    private PrintStream standardOut ;
    private ByteArrayOutputStream outputStreamCaptor;


    @BeforeEach
    public void setUp() {
        standardOut= System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void test_1() {


        Main.main(new String[]{"sample_input/input1.txt"});

        String expectedOutput =
                "C-Cave D-Tower G-Mansion" + System.lineSeparator() +
                        "C-Cave" + System.lineSeparator() +
                        "NO_VACANT_ROOM" + System.lineSeparator() +
                        "G-Mansion" + System.lineSeparator() +
                        "D-Tower" + System.lineSeparator() +
                        "C-Cave" + System.lineSeparator() +
                        "D-Tower" + System.lineSeparator() +
                        "INCORRECT_INPUT" + System.lineSeparator() +
                        "C-Cave" + System.lineSeparator() +
                        "G-Mansion" + System.lineSeparator() +
                        "G-Mansion" + System.lineSeparator() +
                        "NO_VACANT_ROOM";

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());

    }


    @Test
    public void validTime() {
        Slot s1 = new Slot(LocalTime.of(18, 30), LocalTime.of(20, 30));
        Assertions.assertThrows(IllegalArgumentException.class, s1::isValidTimeCheck);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Slot(LocalTime.of(20, 30), LocalTime.of(0, 0)));
        Slot s3 = new Slot(LocalTime.of(9, 0), LocalTime.of(12, 30));
        Assertions.assertThrows(IllegalArgumentException.class, s3::isValidTimeCheck);
        Slot s4 = new Slot(LocalTime.of(17, 30), LocalTime.of(23, 30));
        Assertions.assertThrows(IllegalArgumentException.class, s4::isValidTimeCheck);

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}