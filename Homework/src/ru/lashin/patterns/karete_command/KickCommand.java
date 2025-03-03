package ru.lashin.patterns.karete_command;

public class KickCommand implements Command {

    private final Karate karate;

    public KickCommand(Karate karate) {
        this.karate = karate;
    }

    @Override
    public void execute() {
        karate.kick();
    }
}
