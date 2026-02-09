package ru.danilscheglov.builder.audi;

import ru.danilscheglov.builder.CarBuilder;
import ru.danilscheglov.model.Car;

/**
 * Строитель базовой комплектации Audi A4
 */
public class AudiA4BaseBuilder implements CarBuilder {
    private Car.Builder builder;

    public AudiA4BaseBuilder() {
        this.builder = new Car.Builder("Audi", "A4 35 TFSI", "Базовая", 42000.0);
    }

    @Override
    public void buildExterior() {
        builder.addExteriorOption("Легкосплавные диски 17 дюймов", 0);
        builder.addExteriorOption("Галогенные фары", 0);
        builder.addExteriorOption("Решетка радиатора в цвет кузова", 0);
    }

    @Override
    public void buildInterior() {
        builder.addInteriorOption("Тканевая обивка сидений", 0);
        builder.addInteriorOption("Сиденья с ручной регулировкой", 0);
        builder.addInteriorOption("Стандартная приборная панель", 0);
    }

    @Override
    public void buildComfort() {
        builder.addComfortOption("Механический климат-контроль", 0);
        builder.addComfortOption("Электростеклоподъемники", 0);
        builder.addComfortOption("Круиз-контроль", 0);
    }

    @Override
    public void buildSafety() {
        builder.addSafetyOption("Система ABS", 0);
        builder.addSafetyOption("6 подушек безопасности", 0);
        builder.addSafetyOption("Система стабилизации ESP", 0);
    }

    @Override
    public void buildMultimedia() {
        builder.addMultimediaOption("Дисплей MMI 7 дюймов", 0);
        builder.addMultimediaOption("Аудиосистема на 6 динамиков", 0);
        builder.addMultimediaOption("Bluetooth подключение", 0);
    }

    @Override
    public void buildPerformance() {
        builder.addPerformanceOption("Двигатель 2.0 TFSI (150 л.с.)", 0);
        builder.addPerformanceOption("7-ступенчатая автоматическая коробка S tronic", 0);
        builder.addPerformanceOption("Передний привод", 0);
    }

    @Override
    public Car getCar() {
        return builder.build();
    }
}