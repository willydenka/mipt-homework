package ru.lashin.patterns.karete_command;

public class JumpStrikeCommand implements Command {
    private final Karate karate;

    public JumpStrikeCommand(Karate karate) {
        this.karate = karate;
    }

    @Override
    public void execute() {
        karate.jumpStrike();
    }
}
