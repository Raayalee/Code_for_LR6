package model;

/**
 * Бізнес-тариф — для компаній/професійних клієнтів.
 * Тепер містить:
 *  - пріоритетну підтримку
 *  - персонального менеджера
 *  - роумінг
 */
public class BusinessTariff extends Tariff {

    private final boolean prioritySupport;
    private final boolean dedicatedAccountManager;
    private final boolean roaming;

    public BusinessTariff(String name, double monthlyFee,
                          boolean prioritySupport,
                          boolean dedicatedAccountManager,
                          boolean roaming) {
        super(name, monthlyFee, TariffType.BUSINESS);
        this.prioritySupport = prioritySupport;
        this.dedicatedAccountManager = dedicatedAccountManager;
        this.roaming = roaming;
    }

    @Override
    public String calculateAdditionalFeatures() {
        return String.format(
                "prioritySupport=%b, accountManager=%b, roaming=%b",
                prioritySupport, dedicatedAccountManager, roaming
        );
    }

    @Override
    public String toString() {
        return String.format(
                "[BUSINESS] name='%s' fee=%.2f prioritySupport=%b accountManager=%b roaming=%b",
                getName(), getMonthlyFee(), prioritySupport, dedicatedAccountManager, roaming
        );
    }
}
