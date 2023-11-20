package com.example.geektrust.DTOTest;

import com.example.geektrust.DTO.Slot;
import junit.framework.Assert;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

@DisplayName("Test")
public class SlotTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
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

    @Test
    public void bufferTimeCheck() {
        Slot s1 = new Slot(LocalTime.of(11, 30), LocalTime.of(20, 30));
        Slot s3 = new Slot(LocalTime.of(9, 0), LocalTime.of(12, 30));
        Assert.assertTrue(s3.isOverlapping(s1));
    }

    @Test
    void miscellenousTest() {
        Slot s1 = new Slot(LocalTime.of(17, 30), LocalTime.of(23, 30));
        Slot s2 = new Slot(LocalTime.of(17, 30), LocalTime.of(23, 30));
        Assert.assertTrue(s1.equals(s2));
        Assert.assertTrue(s1.hashCode()== s2.hashCode());
        Assert.assertEquals("Slot [start=17:30, end=23:30]",s1.toString());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


}
