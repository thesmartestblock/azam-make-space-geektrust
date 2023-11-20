package com.example.geektrust.Config;


import com.example.geektrust.Commands.ICommand;

import java.util.HashMap;
import java.util.List;

public class CommandInvoker {
    private final HashMap<String, ICommand> commandBook;

    public CommandInvoker() {
        this.commandBook = new HashMap<>();
    }

    public void registerCommand(String commandName, ICommand command){
        commandBook.put(commandName,command);
    }
    public ICommand getCommand(String commandName) {
        return commandBook.get(commandName);
    }
    public void executeCommand(String commandName,List<String> tokens){
        ICommand command= getCommand(commandName);

        command.execute(tokens);

    }
}
