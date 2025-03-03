package ru.lashin.patterns.karete_command;

public class Main {
    public static void main(String[] args) {
        Karate karatePetya = new Karate("Петя");

        Command command1 = new StrikeCommand(karatePetya);
        Command command2 = new KickCommand(karatePetya);
        Command command3 = new StrikeCommand(karatePetya);
        Command command4 = new JumpStrikeCommand(karatePetya);

        Combination combination = new Combination();
        combination.addCommand(command1);
        combination.addCommand(command2);
        combination.addCommand(command3);
        combination.addCommand(command4);

        combination.executeCommands();
    }
}
