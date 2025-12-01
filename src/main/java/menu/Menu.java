package menu;

import command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Клас меню - відповідає за виклик команд та отримання даних від користувача
 */
public class Menu {
    private Map<String, Command> commands;   // Мапа команд
    private String name;                     // Назва меню
    private Scanner scanner;                 // Для читання вводу

    public Menu(String name) {
        this.name = name;
        this.commands = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }

    private void help() {
        System.out.println("\n--- " + name + " ---");
        System.out.println("Available commands:");
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            String key = entry.getKey();
            String description = entry.getValue().getDescription();
            System.out.println(key + " - " + description);
        }
        System.out.println("help - Show this list");
        System.out.println("exit - Exit the program");
    }

    private void exit() {
        System.out.println("Thanks for using the program. Bye!");
    }

    public void run() {
        System.out.println("Welcome to the tariff management system!");
        help();

        while (true) {
            System.out.print("\nEnter the number of the command (or 'help'): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                exit();
                break;
            }

            if (input.equalsIgnoreCase("help")) {
                help();
                continue;
            }

            // Розділення команди та параметрів
            String[] parts = input.split(" ", 2);
            String commandKey = parts[0];
            String parameters = parts.length > 1 ? parts[1] : "";

            Command command = commands.get(commandKey);

            if (command != null) {
                try {
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
     * Для використання меню як команди (підменю)
     */
    public void execute(String parameters) {
        run();
    }
}
