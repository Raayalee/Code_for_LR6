package model;

/**
 * Студентський тариф — знижка для студентів.
 */
public class StudentTariff extends Tariff {

    private final double discountPercent;              // знижка (0..100)
    private final boolean requiresVerification;        // чи потрібна верифікація студентського квитка

    public StudentTariff(String name, double monthlyFee, double discountPercent, boolean requiresVerification) {
        super(name, monthlyFee, TariffType.STUDENT);

        if (discountPercent < 0 || discountPercent > 100)
            throw new IllegalArgumentException("discountPercent must be in [0,100]");

        this.discountPercent = discountPercent;
        this.requiresVerification = requiresVerification;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public boolean isRequiresVerification() {
        return requiresVerification;
    }

    /**
     * Реальна щомісячна плата зі знижкою.
     */
    public double getDiscountedMonthlyFee() {
        return getMonthlyFee() * (1.0 - discountPercent / 100.0);
    }

    @Override
    public String calculateAdditionalFeatures() {
        return String.format(
                "discountPercent=%.1f, studentIdVerification=%b",
                discountPercent, requiresVerification
        );
    }

    @Override
    public String toString() {
        return "[STUDENT] name='" + getName() +
                "' fee=" + getMonthlyFee() +
                " discountPercent=" + discountPercent +
                " studentIdVerification=" + requiresVerification;
    }
}
