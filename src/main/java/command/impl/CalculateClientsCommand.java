package command.impl;

import command.Command;

/**
 * Команда підрахунку клієнтів, поки що тут пусто
 */
public class CalculateClientsCommand implements Command {

    @Override
    public String getDescription() {
        return "Count the total number of clients";
    }

    @Override
    public void execute(String parameters) {
        // Поки що пусто
        System.out.println("Command: Calculating clients");
    }
}