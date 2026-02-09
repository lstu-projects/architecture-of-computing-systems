package ru.danilscheglov.builder;

import ru.danilscheglov.model.Car;

/**
 * Интерфейс для различных комплектаций автомобилей
 */
public interface CarBuilder {
    void buildExterior();

    void buildInterior();

    void buildComfort();

    void buildSafety();

    void buildMultimedia();

    void buildPerformance();

    Car getCar();
}
