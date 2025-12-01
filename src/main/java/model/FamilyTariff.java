package model;

/**
 * Тариф для родини — передбачає спільний інтернет та кількість членів родини.
 * Наслідує Tariff і вказує тип TariffType.FAMILY.
 */
public class FamilyTariff extends Tariff {

    private final int numberOfFamilyMembers;   // кількість членів сім'ї, >=1
    private final double sharedInternetGB;     // спільний обсяг інтернету в ГБ, >=0
    private final double familyDiscountPercent; // знижка (наприклад, для підключення кількох номерів) 0..100

    public FamilyTariff(String name, double monthlyFee, int numberOfFamilyMembers, double sharedInternetGB, double familyDiscountPercent) {
        super(name, monthlyFee, TariffType.FAMILY);
        if (numberOfFamilyMembers < 1) throw new IllegalArgumentException("numberOfFamilyMembers must be >= 1");
        if (sharedInternetGB < 0) throw new IllegalArgumentException("sharedInternetGB must be >= 0");
        if (familyDiscountPercent < 0 || familyDiscountPercent > 100) throw new IllegalArgumentException("familyDiscountPercent must be in [0,100]");
        this.numberOfFamilyMembers = numberOfFamilyMembers;
        this.sharedInternetGB = sharedInternetGB;
        this.familyDiscountPercent = familyDiscountPercent;
    }

    public int getNumberOfFamilyMembers() {
        return numberOfFamilyMembers;
    }

    public double getSharedInternetGB() {
        return sharedInternetGB;
    }

    public double getFamilyDiscountPercent() {
        return familyDiscountPercent;
    }

    /**
     * Повертає середню вартість на одного члена сім'ї після застосування знижки.
     */
    public double getEffectiveMonthlyFeePerMember() {
        double discounted = getMonthlyFee() * (1.0 - familyDiscountPercent / 100.0);
        return discounted / numberOfFamilyMembers;
    }

    @Override
    public String calculateAdditionalFeatures() {
        return String.format(
                "members=%d, sharedGB=%.1f, familyDiscountPercent=%.1f",
                numberOfFamilyMembers, sharedInternetGB, familyDiscountPercent
        );
    }


    @Override
    public String toString() {
        return String.format(
                "[FAMILY] name='%s' fee=%.2f members=%d sharedGB=%.1f familyDiscountPercent=%.1f",
                getName(), getMonthlyFee(), numberOfFamilyMembers, sharedInternetGB, familyDiscountPercent
        );
    }
}
