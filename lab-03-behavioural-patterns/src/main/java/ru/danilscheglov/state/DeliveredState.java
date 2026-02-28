package ru.danilscheglov.state;

/**
 * Состояние: Доставлен
 */
public class DeliveredState implements OrderState {

    @Override
    public String getName() {
        return "Доставлен";
    }
}