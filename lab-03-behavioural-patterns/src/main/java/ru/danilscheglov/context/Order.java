package ru.danilscheglov.context;

import ru.danilscheglov.observer.Courier;
import ru.danilscheglov.observer.Customer;
import ru.danilscheglov.observer.Warehousekeeper;
import ru.danilscheglov.state.AcceptedState;
import ru.danilscheglov.state.OrderState;

/**
 * Контекст паттерна State.
 * Хранит текущее состояние и делегирует ему вызовы операций.
 */
public class Order {

    private final String id;
    private final Customer customer;
    private Warehousekeeper warehousekeeper;
    private Courier courier;
    private OrderState state;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.state = new AcceptedState();
        System.out.println("=== Создан заказ #" + id + " для " + customer.getName() + " ===");
        customer.update(id, state.getName(), "Заказ зарегистрирован в системе.");
    }

    public void process() {
        state.process(this);
    }

    public void pay() {
        state.pay(this);
    }

    public void approveShipment() {
        state.approveShipment(this);
    }

    public void approveDelivery() {
        state.approveDelivery(this);
    }

    public void deliver() {
        state.deliver(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void setState(OrderState newState) {
        System.out.println("  → Переход: «" + state.getName() + "» → «" + newState.getName() + "»");
        this.state = newState;
    }

    public String getId() {
        return id;
    }

    public String getStateName() {
        return state.getName();
    }

    public void setWarehousekeeper(Warehousekeeper wk) {
        this.warehousekeeper = wk;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public void notifyCustomer(String message) {
        customer.update(id, state.getName(), message);
    }

    public void notifyWarehousekeeper(String message) {
        if (warehousekeeper != null) {
            warehousekeeper.update(id, state.getName(), message);
        }
    }

    public void notifyCourier(String message) {
        if (courier != null) {
            courier.update(id, state.getName(), message);
        }
    }
}

