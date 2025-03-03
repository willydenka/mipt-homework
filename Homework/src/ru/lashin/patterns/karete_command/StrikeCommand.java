package ru.lashin.patterns.karete_command;

public class StrikeCommand implements Command {

    private final Karate karate;

    public StrikeCommand(Karate karate) {
        this.karate = karate;
    }

    @Override
    public void execute() {
        karate.strike();
    }
}
