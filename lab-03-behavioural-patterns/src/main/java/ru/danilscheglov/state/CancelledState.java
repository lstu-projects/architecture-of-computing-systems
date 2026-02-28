package ru.danilscheglov.state;

/**
 * Состояние: Отменён
 */
public class CancelledState implements OrderState {

    @Override
    public String getName() {
        return "Отменён";
    }
}
