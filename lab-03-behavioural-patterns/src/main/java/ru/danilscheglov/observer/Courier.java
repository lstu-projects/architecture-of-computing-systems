package ru.danilscheglov.observer;

/**
 * Курьер — получает уведомление при статусе «Разрешена доставка»
 */
public class Courier {

    private final String name;

    public Courier(String name) {
        this.name = name;
    }

    public void update(String orderId, String status, String message) {
        System.out.printf("  [Курьер %s] Заказ #%s → статус «%s». %s%n", name, orderId, status, message);
    }
}