package ru.danilscheglov.report;

import ru.danilscheglov.model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

/**
 * Класс для генерации HTML-отчета со сравнительной таблицей комплектаций
 */
public class HTMLReportGenerator {

    /**
     * Генерирует HTML-файл со сравнительной таблицей комплектаций
     *
     * @param cars     список автомобилей для сравнения
     * @param filename имя выходного файла
     */
    public void generateComparisonReport(List<Car> cars, String filename) {
        if (cars == null || cars.isEmpty()) {
            System.err.println("Список автомобилей пуст!");
            return;
        }

        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"ru\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        html.append("    <title>Сравнение комплектаций Audi A4</title>\n");
        html.append("    <style>\n");
        html.append("        * { margin: 0; padding: 0; box-sizing: border-box; }\n");
        html.append("        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); padding: 20px; }\n");
        html.append("        .container { max-width: 1400px; margin: 0 auto; background: white; border-radius: 15px; box-shadow: 0 20px 60px rgba(0,0,0,0.3); overflow: hidden; }\n");
        html.append("        .header { background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%); color: white; padding: 30px; text-align: center; }\n");
        html.append("        .header h1 { font-size: 2.5em; margin-bottom: 10px; text-shadow: 2px 2px 4px rgba(0,0,0,0.3); }\n");
        html.append("        .header p { font-size: 1.1em; opacity: 0.9; }\n");
        html.append("        .table-wrapper { overflow-x: auto; padding: 20px; }\n");
        html.append("        table { width: 100%; border-collapse: collapse; }\n");
        html.append("        th, td { padding: 15px; text-align: left; border-bottom: 1px solid #e0e0e0; }\n");
        html.append("        th { background: #f8f9fa; font-weight: 600; color: #2c3e50; position: sticky; top: 0; z-index: 10; }\n");
        html.append("        th:first-child { width: 200px; background: #2c3e50; color: white; }\n");
        html.append("        tr:hover { background-color: #f5f7fa; }\n");
        html.append("        .category-header { background: #3498db !important; color: white !important; font-size: 1.2em; font-weight: bold; }\n");
        html.append("        .price-row { background: #e8f5e9 !important; font-weight: bold; font-size: 1.1em; }\n");
        html.append("        .config-header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white !important; font-size: 1.1em; text-align: center !important; }\n");
        html.append("        .option-present { color: #27ae60; }\n");
        html.append("        .option-absent { color: #e74c3c; }\n");
        html.append("        .checkmark::before { content: '✓ '; font-weight: bold; }\n");
        html.append("        .cross::before { content: '✗ '; font-weight: bold; }\n");
        html.append("        .footer { background: #34495e; color: white; padding: 20px; text-align: center; }\n");
        html.append("    </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("    <div class=\"container\">\n");
        html.append("        <div class=\"header\">\n");
        html.append("            <h1>Сравнение комплектаций Audi A4</h1>\n");
        html.append("            <p>Подробное сравнение опций и характеристик</p>\n");
        html.append("        </div>\n");
        html.append("        <div class=\"table-wrapper\">\n");
        html.append("            <table>\n");

        html.append("                <thead>\n");
        html.append("                    <tr>\n");
        html.append("                        <th>Категория / Опция</th>\n");
        for (Car car : cars) {
            html.append("                        <th class=\"config-header\">").append(car.getConfigurationName()).append("</th>\n");
        }
        html.append("                    </tr>\n");
        html.append("                </thead>\n");
        html.append("                <tbody>\n");

        addInfoRow(html, "Модель", cars, Car::getModel);

        html.append("                    <tr class=\"price-row\">\n");
        html.append("                        <td><strong>Базовая цена</strong></td>\n");
        for (Car car : cars) {
            html.append("                        <td>€").append(String.format("%,.2f", car.getBasePrice())).append("</td>\n");
        }
        html.append("                    </tr>\n");

        addCategorySection(html, "ЭКСТЕРЬЕР", cars, Car::getExterior);
        addCategorySection(html, "ИНТЕРЬЕР", cars, Car::getInterior);
        addCategorySection(html, "КОМФОРТ", cars, Car::getComfort);
        addCategorySection(html, "БЕЗОПАСНОСТЬ", cars, Car::getSafety);
        addCategorySection(html, "МУЛЬТИМЕДИА", cars, Car::getMultimedia);
        addCategorySection(html, "ПРОИЗВОДИТЕЛЬНОСТЬ", cars, Car::getPerformance);

        html.append("                    <tr class=\"price-row\">\n");
        html.append("                        <td><strong>ИТОГОВАЯ ЦЕНА</strong></td>\n");
        for (Car car : cars) {
            html.append("                        <td><strong>€").append(String.format("%,.2f", car.getTotalPrice())).append("</strong></td>\n");
        }
        html.append("                    </tr>\n");

        html.append("                </tbody>\n");
        html.append("            </table>\n");
        html.append("        </div>\n");
        html.append("    </div>\n");
        html.append("</body>\n");
        html.append("</html>\n");

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(html.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при создании HTML-файла: " + e.getMessage());
        }
    }

    /**
     * Добавляет строку с общей информацией
     */
    private void addInfoRow(StringBuilder html, String label, List<Car> cars, Function<Car, String> getter) {
        html.append("                    <tr>\n");
        html.append("                        <td><strong>").append(label).append("</strong></td>\n");
        for (Car car : cars) {
            html.append("                        <td>").append(getter.apply(car)).append("</td>\n");
        }
        html.append("                    </tr>\n");
    }

    /**
     * Добавляет секцию с категорией опций
     */
    private void addCategorySection(StringBuilder html, String categoryName, List<Car> cars, java.util.function.Function<Car, List<String>> getter) {
        Set<String> allOptions = new LinkedHashSet<>();
        for (Car car : cars) {
            allOptions.addAll(getter.apply(car));
        }

        if (allOptions.isEmpty()) {
            return;
        }

        html.append("                    <tr>\n");
        html.append("                        <td colspan=\"").append(cars.size() + 1).append("\" class=\"category-header\">").append(categoryName).append("</td>\n");
        html.append("                    </tr>\n");

        for (String option : allOptions) {
            html.append("                    <tr>\n");
            html.append("                        <td>").append(option).append("</td>\n");

            for (Car car : cars) {
                boolean hasOption = getter.apply(car).contains(option);
                if (hasOption) {
                    html.append("                        <td class=\"option-present checkmark\">Да</td>\n");
                } else {
                    html.append("                        <td class=\"option-absent cross\">Нет</td>\n");
                }
            }
            html.append("                    </tr>\n");
        }
    }
}