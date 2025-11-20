package mainpack;

import menu.Menu;
import command.impl.*;

/**
 * Головний клас програми для 5 лабораторної
 * Демонструє роботу паттерну Command з меню
 */
public class Main {
    public static void main(String[] args) {

        // Створюємо головне меню
        Menu mainMenu = new Menu("Mobile tariff management system");

        // Додаємо команди до меню
        mainMenu.addCommand("1", new CreateTariffCommand());
        mainMenu.addCommand("2", new DeleteTariffCommand());
        mainMenu.addCommand("3", new SortTariffsCommand());
        mainMenu.addCommand("4", new CalculateClientsCommand());
        mainMenu.addCommand("5", new FindTariffsCommand());
        mainMenu.addCommand("6", new ShowTariffsCommand());
        mainMenu.addCommand("7", new ShowStatisticsCommand());

        // Запускаємо головне меню
        mainMenu.run();
    }
}