package ru.danilscheglov.state;

import ru.danilscheglov.context.Order;

/**
 * Состояние: Принят
 */
public class AcceptedState implements OrderState {

    @Override
    public String getName() {
        return "Принят";
    }

    @Override
    public void process(Order order) {
        order.setState(new ProcessingState());
        order.notifyCustomer("Ваш заказ принят в обработку.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
        order.notifyCustomer("Ваш заказ отменён.");
    }
}
