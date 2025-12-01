package factory;

import model.*;

import java.util.Map;

/**
 * Фабрика створення тарифів — за TariffType та параметрами
 */
public class TariffFactory {

    /**
     * params — додаткові параметри:
     * BASIC:   freeMinutes (Integer), internetGB (Double)
     * PREMIUM: internationalCalls (Boolean), roaming (Boolean), entertainment (Boolean)
     * BUSINESS: freeInternationalMinutes (Integer), prioritySupport (Boolean), dedicatedAccountManager (Boolean)
     * FAMILY: members (Integer), sharedGB (Double), familyDiscountPercent (Double)
     * STUDENT: discountPercent (Double), verification (Boolean), freeSocialMediaGB (Integer-optional)
     */
    public Tariff createTariff(TariffType type, String name, double monthlyFee, Map<String, Object> params) {
        if (type == null) type = TariffType.BASIC;

        switch (type) {

            case BASIC: {
                int freeMinutes =
                        params != null && params.get("freeMinutes") instanceof Integer
                                ? (Integer) params.get("freeMinutes")
                                : 0;

                double internetGB =
                        params != null && params.get("internetGB") instanceof Double
                                ? (Double) params.get("internetGB")
                                : 0.0;

                return new BasicTariff(name, monthlyFee, freeMinutes, internetGB);
            }

            case PREMIUM: {
                boolean international =
                        params != null && params.get("internationalCalls") instanceof Boolean
                                ? (Boolean) params.get("internationalCalls")
                                : false;

                boolean roaming =
                        params != null && params.get("roaming") instanceof Boolean
                                ? (Boolean) params.get("roaming")
                                : false;

                boolean entertainment =
                        params != null && params.get("entertainment") instanceof Boolean
                                ? (Boolean) params.get("entertainment")
                                : false;

                return new PremiumTariff(name, monthlyFee, international, roaming, entertainment);
            }

            case BUSINESS: {
                boolean roaming =
                        params != null && params.get("roaming") instanceof Boolean
                                ? (Boolean) params.get("roaming")
                                : false;

                boolean priority =
                        params != null && params.get("prioritySupport") instanceof Boolean
                                ? (Boolean) params.get("prioritySupport")
                                : false;

                boolean manager =
                        params != null && params.get("dedicatedAccountManager") instanceof Boolean
                                ? (Boolean) params.get("dedicatedAccountManager")
                                : false;

                return new BusinessTariff(name, monthlyFee, priority, manager, roaming);
            }


            case FAMILY: {
                int members =
                        params != null && params.get("members") instanceof Integer
                                ? (Integer) params.get("members")
                                : 1;

                double sharedGB =
                        params != null && params.get("sharedGB") instanceof Double
                                ? (Double) params.get("sharedGB")
                                : 0.0;

                double familyDiscount =
                        params != null && params.get("familyDiscountPercent") instanceof Double
                                ? (Double) params.get("familyDiscountPercent")
                                : 0.0;

                return new FamilyTariff(name, monthlyFee, members, sharedGB, familyDiscount);
            }

            case STUDENT: {
                double discount =
                        params != null && params.get("discountPercent") instanceof Double
                                ? (Double) params.get("discountPercent")
                                : 0.0;

                boolean verify =
                        params != null && params.get("verification") instanceof Boolean
                                ? (Boolean) params.get("verification")
                                : false;

                return new StudentTariff(name, monthlyFee, discount, verify);
            }

            default:
                // fallback на BASIC
                int freeMinutes =
                        params != null && params.get("freeMinutes") instanceof Integer
                                ? (Integer) params.get("freeMinutes")
                                : 0;

                double internetGB =
                        params != null && params.get("internetGB") instanceof Double
                                ? (Double) params.get("internetGB")
                                : 0.0;

                return new BasicTariff(name, monthlyFee, freeMinutes, internetGB);
        }
    }
}
