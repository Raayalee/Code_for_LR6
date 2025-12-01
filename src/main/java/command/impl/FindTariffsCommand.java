package command.impl;

import command.Command;
import model.Tariff;
import service.DataValidator;
import service.SearchService;

import java.util.List;

/**
 * Пошук тарифів у ціновому діапазоні.
 * parameters: min max
 */
public class FindTariffsCommand implements Command {
    private final List<Tariff> tariffs;
    private final SearchService searchService;
    private final DataValidator validator;

    public FindTariffsCommand(List<Tariff> tariffs, SearchService searchService, DataValidator validator) {
        this.tariffs = tariffs;
        this.searchService = searchService;
        this.validator = validator;
    }

    @Override
    public String getDescription() {
        return "Find tariffs in price range. Usage: min max";
    }

    @Override
    public void execute(String parameters) {
        try {
            if (parameters == null || parameters.trim().isEmpty()) {
                System.out.println("Provide min and max price. Example: 100 500");
                return;
            }
            String[] parts = parameters.trim().split("\\s+");
            if (parts.length < 2) {
                System.out.println("Need two numbers: min max");
                return;
            }
            double min = Double.parseDouble(parts[0]);
            double max = Double.parseDouble(parts[1]);
            if (!validator.validatePriceRange(min, max)) {
                System.out.println("Invalid price range.");
                return;
            }
            List<Tariff> found = searchService.filterByPriceRange(tariffs, min, max);
            if (found.isEmpty()) {
                System.out.println("No tariffs in the given range.");
            } else {
                System.out.println("Found tariffs:");
                found.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error while searching: " + e.getMessage());
        }
    }
}
