package command.impl;

import command.Command;
import model.Client;
import model.Tariff;
import model.TariffType;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Видалення тарифу за назвою з підтвердженням.
 * Після видалення всіх клієнтів тарифу переводить на BASIC.
 */
public class DeleteTariffCommand implements Command {

    private final List<Tariff> tariffs;
    private final List<Client> clients;
    private final Scanner scanner = new Scanner(System.in);

    public DeleteTariffCommand(List<Tariff> tariffs, List<Client> clients) {
        this.tariffs = tariffs;
        this.clients = clients;
    }

    @Override
    public String getDescription() {
        return "Delete tariff by name. Usage: name";
    }

    @Override
    public void execute(String parameters) {
        if (parameters == null || parameters.trim().isEmpty()) {
            System.out.println("Provide tariff name to delete.");
            return;
        }

        String name = parameters.trim();
        Optional<Tariff> targetOpt = tariffs.stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst();

        if (targetOpt.isEmpty()) {
            System.out.println("Tariff not found: " + name);
            return;
        }

        Tariff target = targetOpt.get();

        // Кількість клієнтів на цьому тарифі
        long subscriberCount = clients.stream()
                .filter(c -> c.getCurrentTariff() != null &&
                        c.getCurrentTariff().getName().equalsIgnoreCase(name))
                .count();

        System.out.printf("Tariff '%s' selected. Subscribers: %d%n", name, subscriberCount);

        // Цикл підтвердження
        boolean confirmed = false;
        while (true) {
            System.out.print("Are you sure you want to delete this tariff? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                confirmed = true;
                break;
            } else if (input.equals("n") || input.equals("no")) {
                System.out.println("Deletion canceled.");
                return;
            } else {
                System.out.println("Invalid input. Please type 'y' or 'n'.");
            }
        }

        if (!confirmed) return;

        // Знаходимо BASIC тариф
        Optional<Tariff> basicOpt = tariffs.stream()
                .filter(t -> t.getType() == TariffType.BASIC)
                .findFirst();

        if (basicOpt.isEmpty()) {
            System.out.println("No BASIC tariff available. Cannot transfer clients.");
            return;
        }

        Tariff basicTariff = basicOpt.get();

        // Переводимо клієнтів на BASIC
        for (Client c : clients) {
            if (c.getCurrentTariff() != null &&
                    c.getCurrentTariff().getName().equalsIgnoreCase(name)) {
                c.subscribeToTariff(basicTariff);
            }
        }

        // Видаляємо тариф
        Iterator<Tariff> it = tariffs.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(name)) {
                it.remove();
                break;
            }
        }

        System.out.printf("Tariff '%s' deleted. All subscribers moved to BASIC tariff '%s'.%n",
                name, basicTariff.getName());
    }
}
