package model;

/**
 * Клієнт — зберігає поточний тариф
 */
public class Client {
    private String name;
    private String phoneNumber;
    private Tariff currentTariff;

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentTariff = null;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Tariff getCurrentTariff() {
        return currentTariff;
    }

    public void subscribeToTariff(Tariff tariff) {
        if (this.currentTariff != null) {
            this.currentTariff.decrementClientCount();
        }
        this.currentTariff = tariff;
        if (tariff != null) tariff.incrementClientCount();
    }

    @Override
    public String toString() {
        return String.format("Client{name='%s', phone='%s', tariff=%s}",
                name, phoneNumber, currentTariff == null ? "none" : currentTariff.getName());
    }
}
