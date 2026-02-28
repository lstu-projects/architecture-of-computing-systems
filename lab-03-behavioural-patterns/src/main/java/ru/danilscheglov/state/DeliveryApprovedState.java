package ru.danilscheglov.state;

import ru.danilscheglov.context.Order;

/**
 * Состояние: Разрешена доставка
 */
public class DeliveryApprovedState implements OrderState {

    @Override
    public String getName() {
        return "Разрешена доставка";
    }

    @Override
    public void deliver(Order order) {
        order.setState(new DeliveredState());
        order.notifyCustomer("Ваш заказ доставлен. Спасибо за покупку!");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
        order.notifyCustomer("Ваш заказ отменён во время доставки.");
    }
}
