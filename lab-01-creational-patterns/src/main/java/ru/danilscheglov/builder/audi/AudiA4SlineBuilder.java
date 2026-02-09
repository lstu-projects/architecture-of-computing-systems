package ru.danilscheglov.builder.audi;

import ru.danilscheglov.builder.CarBuilder;
import ru.danilscheglov.model.Car;

/**
 * Строитель спортивной комплектации Audi A4 S line
 */
public class AudiA4SlineBuilder implements CarBuilder {
    private Car.Builder builder;

    public AudiA4SlineBuilder() {
        this.builder = new Car.Builder("Audi", "A4 40 TFSI", "S line", 50000.0);
    }

    @Override
    public void buildExterior() {
        builder.addExteriorOption("Легкосплавные диски S line 19 дюймов", 1500);
        builder.addExteriorOption("Светодиодные фары Matrix LED", 1400);
        builder.addExteriorOption("Спортивный обвес S line", 2200);
        builder.addExteriorOption("Спортивная выхлопная система", 900);
        builder.addExteriorOption("Черная отделка Black optic", 700);
    }

    @Override
    public void buildInterior() {
        builder.addInteriorOption("Спортивные сиденья S line с кожей/Alcantara", 1900);
        builder.addInteriorOption("Сиденья с электрорегулировкой и памятью", 1400);
        builder.addInteriorOption("Спортивный руль S line", 450);
        builder.addInteriorOption("Алюминиевая отделка салона", 550);
        builder.addInteriorOption("Декоративная подсветка контуров салона", 400);
    }

    @Override
    public void buildComfort() {
        builder.addComfortOption("3-зонный автоматический климат-контроль", 850);
        builder.addComfortOption("Подогрев передних сидений", 550);
        builder.addComfortOption("Электропривод крышки багажника", 500);
        builder.addComfortOption("Адаптивный круиз-контроль ACC", 1300);
        builder.addComfortOption("Audi Parking system plus", 750);
    }

    @Override
    public void buildSafety() {
        builder.addSafetyOption("Расширенная система подушек безопасности (8 шт.)", 550);
        builder.addSafetyOption("Ассистент движения в полосе", 650);
        builder.addSafetyOption("Ассистент предотвращения столкновений", 750);
        builder.addSafetyOption("Контроль слепых зон", 850);
        builder.addSafetyOption("Система помощи при выезде задним ходом", 450);
    }

    @Override
    public void buildMultimedia() {
        builder.addMultimediaOption("Сенсорный дисплей MMI 10.1 дюйма", 1100);
        builder.addMultimediaOption("Audi Virtual Cockpit Plus 12.3 дюйма", 1600);
        builder.addMultimediaOption("Акустика Bang & Olufsen 3D (16 динамиков)", 1300);
        builder.addMultimediaOption("Беспроводная зарядка Audi Phone Box", 300);
        builder.addMultimediaOption("Apple CarPlay и Android Auto", 0);
    }

    @Override
    public void buildPerformance() {
        builder.addPerformanceOption("Двигатель 2.0 TFSI (190 л.с.)", 3500);
        builder.addPerformanceOption("7-ступенчатая S tronic", 900);
        builder.addPerformanceOption("Спортивная подвеска S line", 1100);
        builder.addPerformanceOption("Прогрессивное рулевое управление", 550);
    }

    @Override
    public Car getCar() {
        return builder.build();
    }
}