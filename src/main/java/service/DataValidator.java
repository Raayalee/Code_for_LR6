package service;

/**
 * Простий валідатор для тарифів / діапазонів
 */
public class DataValidator {

    public boolean validateTariff(String name, double monthlyFee) {
        if (name == null || name.trim().isEmpty()) return false;
        if (monthlyFee < 0) return false;
        return true;
    }

    public boolean validatePriceRange(double min, double max) {
        return !(min < 0 || max < 0 || min > max);
    }
}
