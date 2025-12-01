package model;

/**
 * Абстрактний тариф
 */
public abstract class Tariff {
    protected String name;
    protected double monthlyFee;
    protected int clientCount;
    protected TariffType type;

    public Tariff(String name, double monthlyFee, TariffType type) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.type = type;
        this.clientCount = 0;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public TariffType getType() {
        return type;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public void incrementClientCount() {
        this.clientCount++;
    }

    public void decrementClientCount() {
        if (clientCount > 0) clientCount--;
    }

    /**
     * Калькуляція додаткових фіч — різна для підкласів
     */
    public abstract String calculateAdditionalFeatures();

    @Override
    public String toString() {
        return String.format("[%s] name='%s' fee=%.2f clients=%d features={%s}",
                type, name, monthlyFee, clientCount, calculateAdditionalFeatures());
    }
}
