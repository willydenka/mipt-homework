package ru.lashin.patterns.karete_command;

import java.util.*;

public class Combination {
    private final List<Command> listOfCommand = new ArrayList<>();

    public void addCommand(Command command) {
        listOfCommand.add(command);
    }

    public void deleteCommand(Command command) {
        listOfCommand.remove(command);
    }

    public void executeCommands() {
        for (Command command : listOfCommand)
            command.execute();
    }
}
