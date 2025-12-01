package service;

import model.Tariff;
import model.TariffType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервіс пошуку/фільтрації тарифів
 */
public class SearchService {

    public List<Tariff> filterByPriceRange(List<Tariff> tariffs, double min, double max) {
        return tariffs.stream()
                .filter(t -> t.getMonthlyFee() >= min && t.getMonthlyFee() <= max)
                .collect(Collectors.toList());
    }

    public List<Tariff> filterByType(List<Tariff> tariffs, TariffType type) {
        return tariffs.stream()
                .filter(t -> t.getType() == type)
                .collect(Collectors.toList());
    }
}
