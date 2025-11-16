package command.impl;

import command.Command;

/**
 * Команда відображення тарифів, пустує до наступних лабораорних
 */
public class ShowTariffsCommand implements Command {

    @Override
    public String getDescription() {
        return "Show all tariffs";
    }

    @Override
    public void execute(String parameters) {
        // Поки що пусто
        System.out.println("Command: Showing all tariffs");
    }
}