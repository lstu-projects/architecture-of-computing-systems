package ru.danilscheglov.state;

import ru.danilscheglov.context.Order;

/**
 * Интерфейс состояния заказа.
 * Default-методы бросают IllegalStateException для недопустимых переходов,
 * поэтому конкретные классы переопределяют только разрешённые операции.
 */
public interface OrderState {

    String getName();

    default void process(Order order) {
        throw new IllegalStateException("Действие «В обработку» недопустимо в состоянии «" + getName() + "».");
    }

    default void pay(Order order) {
        throw new IllegalStateException("Действие «Оплатить» недопустимо в состоянии «" + getName() + "».");
    }

    default void approveShipment(Order order) {
        throw new IllegalStateException("Действие «Разрешить отгрузку» недопустимо в состоянии «" + getName() + "».");
    }

    default void approveDelivery(Order order) {
        throw new IllegalStateException("Действие «Разрешить доставку» недопустимо в состоянии «" + getName() + "».");
    }

    default void deliver(Order order) {
        throw new IllegalStateException("Действие «Доставить» недопустимо в состоянии «" + getName() + "».");
    }

    default void cancel(Order order) {
        throw new IllegalStateException("Действие «Отменить» недопустимо в состоянии «" + getName() + "».");
    }
}