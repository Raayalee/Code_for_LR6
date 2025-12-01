package model;

/**
 * Преміум тариф — roaming, internationalCalls, entertainmentPackage
 */
public class PremiumTariff extends Tariff {
    private boolean internationalCalls;
    private boolean roaming;
    private boolean entertainmentPackage;

    public PremiumTariff(String name, double monthlyFee,
                         boolean internationalCalls, boolean roaming, boolean entertainmentPackage) {
        super(name, monthlyFee, TariffType.PREMIUM);
        this.internationalCalls = internationalCalls;
        this.roaming = roaming;
        this.entertainmentPackage = entertainmentPackage;
    }

    public boolean hasInternationalCalls() {
        return internationalCalls;
    }

    public boolean hasRoaming() {
        return roaming;
    }

    public boolean hasEntertainmentPackage() {
        return entertainmentPackage;
    }

    @Override
    public String calculateAdditionalFeatures() {
        return String.format(
                "internationalCalls=%b, roaming=%b, entertainment=%b",
                internationalCalls, roaming, entertainmentPackage
        );
    }

    @Override
    public String toString() {
        return String.format(
                "[PREMIUM] name='%s' fee=%.2f internationalCalls=%b roaming=%b entertainment=%b",
                getName(), getMonthlyFee(), internationalCalls, roaming, entertainmentPackage
        );
    }
}
