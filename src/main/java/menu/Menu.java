package menu;

import command.Command;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Клас меню - відповідає за виклик команд та отримання даних від користувача
 * Може бути командою для іншого меню (багаторівневе меню)
 */
public class Menu {
    private Map<String, Command> commands;  // Мапа команд: ключ -> команда
    private String name;                    // Назва меню
    private boolean isRunning;              // Стан виконання
    private Scanner scanner;                // Для читання вводу

    public Menu(String name) {
        this.name = name;
        this.commands = new HashMap<>();
        this.isRunning = false;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Додати команду до меню
     */
    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }

    /**
     * Метод help - реалізований БЕЗ інтерфейсу Command
     * Формує підказку користувача на основі мапи команд
     */
    private void help() {
        System.out.println("\n--- " + name + " ---");
        System.out.println("Available commands:");

        // Пробігаємо по мапі та формуємо підказку
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            String key = entry.getKey();
            String description = entry.getValue().getDescription();
            System.out.println(key + " - " + description);
        }

        System.out.println("help - Show this list");
        System.out.println("exit - Exit the program");
    }

    /**
     * Головний метод run - циклічно запитує користувача про команди
     */
    public void run() {
        isRunning = true;
        System.out.println("Welcome to the tariff management system!");
        help();

        // Головний цикл програми
        while (isRunning) {
            System.out.print("\nEnter the number of the command: ");
            String input = scanner.nextLine().trim();

            // Команда exit - реалізована БЕЗ інтерфейсу Command
            if (input.equalsIgnoreCase("exit")) {
                exit();
                continue;
            }

            // Команда help - реалізована БЕЗ інтерфейсу Command
            if (input.equalsIgnoreCase("help")) {
                help();
                continue;
            }

            // Розділяємо ввід на команду та параметри (як git checkout new_branch)
            String[] parts = input.split(" ", 2);
            String commandKey = parts[0];
            String parameters = parts.length > 1 ? parts[1] : "";

            // Шукаємо команду в мапі
            Command command = commands.get(commandKey);
            if (command != null) {
                try {
                    // Виконуємо команду з параметрами
                    command.execute(parameters);
                } catch (Exception e) {
                    System.out.println("Error while executing command: " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command: " + commandKey);
                System.out.println("Enter 'help' to view available commands");
            }
        }
    }

    /**
     * Метод exit - реалізований БЕЗ інтерфейсу Command
     */
    private void exit() {
        System.out.println("Thanks for using our program. Have a good day!");
        isRunning = false;
        scanner.close();
    }

    /**
     * Може бути використаний як команда для іншого меню
     */
    public void execute(String parameters) {
        run();
    }
}