package command.impl;

import command.Command;

/**
 * Команда сортування тарифів, тут пусто
 */
public class SortTariffsCommand implements Command {

    @Override
    public String getDescription() {
        return "Sort tariffs by price";
    }

    @Override
    public void execute(String parameters) {
        // Поки що порожньо
        System.out.println("Command: Sorting tariffs");
    }
}