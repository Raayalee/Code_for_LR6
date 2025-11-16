package command.impl;

import command.Command;

/**
 * Команда створення тарифу, поки що пуста
 */
public class CreateTariffCommand implements Command {

    @Override
    public String getDescription() {
        return "Create new tariff";
    }

    @Override
    public void execute(String parameters) {
        // Логіка буде в наступних лабах
        System.out.println("Command: Creating new tariff");
        System.out.println("Parameters: " + parameters);
    }
}