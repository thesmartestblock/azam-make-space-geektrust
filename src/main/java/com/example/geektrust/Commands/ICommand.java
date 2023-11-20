package com.example.geektrust.Commands;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);
}
