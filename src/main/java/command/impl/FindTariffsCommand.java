package command.impl;

import command.Command;

/**
 * Команда пошуку тарифів, до наступних лабораторних, тут пусто
 */
public class FindTariffsCommand implements Command {

    @Override
    public String getDescription() {
        return "Find tariffs in a price range";
    }

    @Override
    public void execute(String parameters) {
        // Поки що логіки виконання немає
        System.out.println("Command: Looking for tariffs in a concrete price range");
        System.out.println("Parameters: " + parameters);
    }
}