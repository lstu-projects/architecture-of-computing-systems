package ru.danilscheglov;

import ru.danilscheglov.builder.CarBuilder;
import ru.danilscheglov.builder.CarDirector;
import ru.danilscheglov.builder.audi.AudiA4BaseBuilder;
import ru.danilscheglov.builder.audi.AudiA4PremiumBuilder;
import ru.danilscheglov.builder.audi.AudiA4SlineBuilder;
import ru.danilscheglov.model.Car;
import ru.danilscheglov.report.HTMLReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Генерация HTML-отчета со сравнением комплектаций Audi A4...");

        CarDirector director = new CarDirector();

        List<Car> cars = new ArrayList<>();

        // Сборка базовой комплектации
        CarBuilder baseBuilder = new AudiA4BaseBuilder();
        Car baseCar = director.constructCar(baseBuilder);
        cars.add(baseCar);

        // Сборка спортивной комплектации S line
        CarBuilder slineBuilder = new AudiA4SlineBuilder();
        Car slineCar = director.constructCar(slineBuilder);
        cars.add(slineCar);

        // Сборка люксовой комплектации Premium Plus
        CarBuilder premiumBuilder = new AudiA4PremiumBuilder();
        Car premiumCar = director.constructCar(premiumBuilder);
        cars.add(premiumCar);

        // Пример использования Builder напрямую для кастомной конфигурации
        Car customCar = new Car.Builder("Audi", "A4 35 TDI", "Кастомная", 45000.0)
                .addExteriorOption("Легкосплавные диски 18 дюймов", 900)
                .addExteriorOption("Светодиодные фары LED", 1000)
                .addInteriorOption("Спортивные кожаные сиденья", 1300)
                .addComfortOption("Адаптивный круиз-контроль ACC", 1300)
                .addSafetyOption("Ассистент движения в полосе", 750)
                .addMultimediaOption("Премиум аудиосистема", 1100)
                .addPerformanceOption("Дизельный двигатель 2.0 TDI (163 л.с.)", 3200)
                .build();

        cars.add(customCar);

        HTMLReportGenerator reportGenerator = new HTMLReportGenerator();
        reportGenerator.generateComparisonReport(cars, "audi_comparison.html");

        System.out.println("HTML-отчет успешно создан: audi_comparison.html");
    }
}