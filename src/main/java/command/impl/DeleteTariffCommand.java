package command.impl;

import command.Command;

/**
 * Команда видалення тарифу, поки що порожня
 */
public class DeleteTariffCommand implements Command {

    @Override
    public String getDescription() {
        return "Delete tariff by name";
    }

    @Override
    public void execute(String parameters) {
        // Поки що порожньо
        System.out.println("Command: Deleting tariff by name");
        System.out.println("Parameters: " + parameters);
    }
}