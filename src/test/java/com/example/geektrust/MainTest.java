package com.example.geektrust;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Test")
public class MainTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;


    @BeforeEach
    public void setUp() {
        standardOut = System.out;
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

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}