package ru.danilscheglov.builder.audi;

import ru.danilscheglov.builder.CarBuilder;
import ru.danilscheglov.model.Car;

/**
 * Строитель люксовой комплектации Audi A4 Premium Plus
 */
public class AudiA4PremiumBuilder implements CarBuilder {
    private Car.Builder builder;

    public AudiA4PremiumBuilder() {
        this.builder = new Car.Builder("Audi", "A4 45 TFSI quattro", "Premium Plus", 56000.0);
    }

    @Override
    public void buildExterior() {
        builder.addExteriorOption("Легкосплавные диски Premium 18 дюймов", 1100);
        builder.addExteriorOption("Светодиодные фары HD Matrix LED с лазером", 1800);
        builder.addExteriorOption("Хромированная отделка радиатора", 450);
        builder.addExteriorOption("Хромированные молдинги окон", 350);
        builder.addExteriorOption("Панорамная стеклянная крыша", 1600);
    }

    @Override
    public void buildInterior() {
        builder.addInteriorOption("Кожаная обивка Valcona", 2400);
        builder.addInteriorOption("Комфортные сиденья с вентиляцией и массажем", 2000);
        builder.addInteriorOption("Деревянная отделка Fine Grain Ash", 850);
        builder.addInteriorOption("Расширенная подсветка контуров Plus", 550);
        builder.addInteriorOption("Премиальные коврики с отделкой", 200);
    }

    @Override
    public void buildComfort() {
        builder.addComfortOption("4-зонный автоматический климат-контроль", 1100);
        builder.addComfortOption("Подогрев и вентиляция передних и задних сидений", 1000);
        builder.addComfortOption("Функция массажа передних сидений", 900);
        builder.addComfortOption("Система доступа Audi Advanced Key", 550);
        builder.addComfortOption("Электрические шторки задних дверей и стекла", 450);
        builder.addComfortOption("Ароматизация салона", 300);
    }

    @Override
    public void buildSafety() {
        builder.addSafetyOption("Расширенная система подушек безопасности (10 шт.)", 900);
        builder.addSafetyOption("Audi Pre Sense 360°", 1000);
        builder.addSafetyOption("Активный ассистент полосы движения", 800);
        builder.addSafetyOption("Адаптивный круиз-контроль с функцией пробок", 1600);
        builder.addSafetyOption("Камера кругового обзора 360°", 1300);
        builder.addSafetyOption("Проекционный дисплей на лобовое стекло", 1200);
    }

    @Override
    public void buildMultimedia() {
        builder.addMultimediaOption("Цифровая приборная панель Virtual Cockpit 12.3 дюйма", 1300);
        builder.addMultimediaOption("Дисплей MMI Navigation plus 10.1 дюйма", 1100);
        builder.addMultimediaOption("Audi Connect с 4G LTE", 2200);
        builder.addMultimediaOption("Премиум акустика Bang & Olufsen 3D Advanced", 3800);
        builder.addMultimediaOption("Управление жестами", 450);
        builder.addMultimediaOption("WiFi точка доступа", 350);
    }

    @Override
    public void buildPerformance() {
        builder.addPerformanceOption("Двигатель 2.0 TFSI (245 л.с.)", 4500);
        builder.addPerformanceOption("7-ступенчатая S tronic", 900);
        builder.addPerformanceOption("Адаптивная пневмоподвеска", 1400);
        builder.addPerformanceOption("Полный привод quattro ultra", 2000);
        builder.addPerformanceOption("Динамическое рулевое управление", 1000);
    }

    @Override
    public Car getCar() {
        return builder.build();
    }
}