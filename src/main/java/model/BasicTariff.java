package model;

/**
 * Простий тариф — freeMinutes, internetGB
 */
public class BasicTariff extends Tariff {
    private int freeMinutes;
    private double internetGB;

    public BasicTariff(String name, double monthlyFee, int freeMinutes, double internetGB) {
        super(name, monthlyFee, TariffType.BASIC);
        this.freeMinutes = freeMinutes;
        this.internetGB = internetGB;
    }

    public int getFreeMinutes() {
        return freeMinutes;
    }

    public double getInternetGB() {
        return internetGB;
    }

    @Override
    public String toString() {
        return String.format(
                "[BASIC] name='%s' fee=%.2f freeMinutes=%d internetGB=%.1f",
                getName(), getMonthlyFee(), freeMinutes, internetGB
        );
    }

    @Override
    public String calculateAdditionalFeatures() {
        return String.format("freeMinutes=%d, internetGB=%.1f", freeMinutes, internetGB);
    }

}
