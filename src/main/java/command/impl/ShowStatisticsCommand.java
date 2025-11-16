package command.impl;

import command.Command;

/**
 * Команда відображення статистики, досі пустує
 */
public class ShowStatisticsCommand implements Command {

    @Override
    public String getDescription() {
        return "Show statistics";
    }

    @Override
    public void execute(String parameters) {
        // Пусто до наступних лабораторних
        System.out.println("Command: Showing statistics");
    }
}