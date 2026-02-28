package ru.danilscheglov.state;

import ru.danilscheglov.context.Order;

/**
 * Состояние: Разрешена отгрузка
 */
public class ShipmentApprovedState implements OrderState {

    @Override
    public String getName() {
        return "Разрешена отгрузка";
    }

    @Override
    public void approveDelivery(Order order) {
        order.setState(new DeliveryApprovedState());
        order.notifyCustomer("Доставка вашего заказа разрешена, ожидайте курьера.");
        order.notifyCourier("Заберите заказ #" + order.getId() + " со склада и доставьте покупателю.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
        order.notifyCustomer("Ваш заказ отменён после разрешения отгрузки.");
    }
}
