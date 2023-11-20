package com.example.geektrust;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.example.geektrust.Services.MeetingRoomService;

public class Main {
    private static final MeetingRoomService service = new MeetingRoomService();
    public static void main(String[] args) {
        
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                List<String> tokens = Arrays.stream(inputLine.split(" ")).collect(Collectors.toList());
                run(tokens);
            }
            sc.close(); // closes the scanner
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    private static void run(List<String> tokens) {
        switch (tokens.get(0)) {
            case "BOOK":
                    service.bookMeetingRoom(tokens);
                break;
            case "VACANCY":
                    service.vacancyCheck(tokens);
                break;
            default:
                System.out.println("INVALID_INPUT");
                break;
        }
    }

}
