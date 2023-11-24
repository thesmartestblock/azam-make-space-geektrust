package com.example.geektrust;

import com.example.geektrust.Config.CommandInvoker;
import com.example.geektrust.Config.Config;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Config config = new Config();

    public static void main(String[] args) {

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                List<String> tokens = Arrays.stream(inputLine.split(" ")).collect(Collectors.toList());
                CommandInvoker invoker = config.getCommandInvoker();
                invoker.executeCommand(tokens.get(0), tokens);
            }
            sc.close(); // closes the scanner
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
