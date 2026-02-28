package ru.danilscheglov;

import ru.danilscheglov.context.Order;
import ru.danilscheglov.observer.Courier;
import ru.danilscheglov.observer.Customer;
import ru.danilscheglov.observer.Warehousekeeper;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Щеглов Данил");
        Warehousekeeper keeper = new Warehousekeeper("Иванов Иван");
        Courier courier = new Courier("Алексей Быстров");

        System.out.println("СЦЕНАРИЙ 1: Полный успешный путь заказа");

        Order order1 = new Order("ORDER-01", customer);
        order1.setWarehousekeeper(keeper);
        order1.setCourier(courier);

        System.out.println();
        order1.process();
        System.out.println();
        order1.pay();
        System.out.println();
        order1.approveShipment();
        System.out.println();
        order1.approveDelivery();
        System.out.println();
        order1.deliver();
        System.out.println("\nИтоговый статус: " + order1.getStateName());
        System.out.println();

        System.out.println("СЦЕНАРИЙ 2: Отмена после оплаты");

        Order order2 = new Order("ORDER-02", customer);
        order2.setWarehousekeeper(keeper);
        order2.setCourier(courier);

        System.out.println();
        order2.process();
        System.out.println();
        order2.pay();
        System.out.println();
        order2.cancel();
        System.out.println("\nИтоговый статус: " + order2.getStateName());
        System.out.println();

        System.out.println("СЦЕНАРИЙ 3: Недопустимый переход");

        Order order3 = new Order("ORDER-03", customer);
        System.out.println();
        try {
            order3.deliver();
        } catch (IllegalStateException e) {
            System.out.println("  [ОШИБКА] " + e.getMessage());
        }
        System.out.println("\nИтоговый статус: " + order3.getStateName());
    }
}