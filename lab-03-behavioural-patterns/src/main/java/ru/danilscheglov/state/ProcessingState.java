package ru.danilscheglov.state;

import ru.danilscheglov.context.Order;

/**
 * Состояние: В обработке
 */
public class ProcessingState implements OrderState {

    @Override
    public String getName() {
        return "В обработке";
    }

    @Override
    public void pay(Order order) {
        order.setState(new PaidState());
        order.notifyCustomer("Оплата подтверждена, спасибо!");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
        order.notifyCustomer("Ваш заказ отменён во время обработки.");
    }
}
