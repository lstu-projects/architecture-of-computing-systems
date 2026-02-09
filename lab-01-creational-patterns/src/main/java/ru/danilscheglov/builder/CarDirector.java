package ru.danilscheglov.builder;

import ru.danilscheglov.model.Car;

/**
 * Класс Director управляет процессом сборки автомобиля.
 */
public class CarDirector {

    /**
     * Метод собирает полную комплектацию автомобиля
     *
     * @param builder строитель конкретной комплектации
     * @return собранный автомобиль
     */
    public Car constructCar(CarBuilder builder) {
        builder.buildExterior();
        builder.buildInterior();
        builder.buildComfort();
        builder.buildSafety();
        builder.buildMultimedia();
        builder.buildPerformance();
        return builder.getCar();
    }
}