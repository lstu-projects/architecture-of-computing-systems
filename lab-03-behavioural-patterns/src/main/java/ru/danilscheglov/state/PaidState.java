package ru.danilscheglov.state;

import ru.danilscheglov.context.Order;

/**
 * Состояние: Оплачен
 */
public class PaidState implements OrderState {

    @Override
    public String getName() {
        return "Оплачен";
    }

    @Override
    public void approveShipment(Order order) {
        order.setState(new ShipmentApprovedState());
        order.notifyCustomer("Отгрузка вашего заказа разрешена.");
        order.notifyWarehousekeeper("Подготовьте заказ #" + order.getId() + " к отгрузке.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
        order.notifyCustomer("Ваш заказ отменён. Средства будут возвращены.");
    }
}
