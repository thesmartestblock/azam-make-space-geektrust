package com.example.geektrust.ServiceTest;

        import com.example.geektrust.DTO.MeetingRoom;
        import com.example.geektrust.DTO.Slot;
        import com.example.geektrust.Exceptions.InvalidInputException;
        import com.example.geektrust.Exceptions.NoRoomsException;
        import com.example.geektrust.Service.RoomBookingService;
        import com.example.geektrust.Service.VacantRoomsService;
        import junit.framework.Assert;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.time.LocalTime;
        import java.util.Arrays;
        import java.util.List;

public class VacantRoomServiceTest {

    VacantRoomsService vacantRoomsService;

    @BeforeEach
    void setup(){
        List<MeetingRoom> rooms = Arrays.asList(new MeetingRoom(3,"C-Cave"),new MeetingRoom(7,"D-Tower"), new MeetingRoom(20,"G-Mansion"));
        vacantRoomsService = new VacantRoomsService(rooms);
    }
    @Test
    public void edgeCasesOfVacancyService() throws InvalidInputException, NoRoomsException {
        Slot test1=new Slot(LocalTime.parse("09:00"),LocalTime.parse("10:30"));
        Slot test2=new Slot(LocalTime.parse("09:30"),LocalTime.parse("10:30"));
        Assert.assertEquals("C-Cave D-Tower G-Mansion",vacantRoomsService.checkVacancy(test2));
    }
}
