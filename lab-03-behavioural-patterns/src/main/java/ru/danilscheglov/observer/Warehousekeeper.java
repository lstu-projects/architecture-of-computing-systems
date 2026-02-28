package ru.danilscheglov.observer;

/**
 * Кладовщик — получает уведомление при статусе «Разрешена отгрузка»
 */
public class Warehousekeeper {

    private final String name;

    public Warehousekeeper(String name) {
        this.name = name;
    }

    public void update(String orderId, String status, String message) {
        System.out.printf("  [Кладовщик %s] Заказ #%s → статус «%s». %s%n", name, orderId, status, message);
    }
}
