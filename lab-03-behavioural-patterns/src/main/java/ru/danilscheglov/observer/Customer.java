package ru.danilscheglov.observer;

/**
 * Покупатель — получает уведомления при каждом изменении статуса
 */
public class Customer {

    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public void update(String orderId, String status, String message) {
        System.out.printf("  [Покупатель %s] Заказ #%s → статус «%s». %s%n", name, orderId, status, message);
    }

    public String getName() {
        return name;
    }
}
