package ru.danilscheglov;

/**
 * Демонстрационный класс для тестирования паттерна Компоновщик
 * в контексте организационной структуры предприятия
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("СИСТЕМА УПРАВЛЕНИЯ ОРГАНИЗАЦИОННОЙ СТРУКТУРОЙ ПРЕДПРИЯТИЯ");
        System.out.println("Паттерн проектирования: Компоновщик (Composite)");
        System.out.println();

        Department company = new Department("ORG-001", "ООО \"Технологии Будущего\"");

        company.addPosition(new Position("Генеральный директор", 1, 150000));
        company.addPosition(new Position("Финансовый директор", 1, 120000));

        Department itDepartment = new Department("IT-001", "Отдел информационных технологий");
        itDepartment.addPosition(new Position("Руководитель IT-отдела", 1, 100000));
        itDepartment.addPosition(new Position("Системный администратор", 2, 70000));

        Department devDepartment = new Department("IT-DEV-001", "Отдел разработки");
        devDepartment.addPosition(new Position("Ведущий разработчик", 1, 110000));
        devDepartment.addPosition(new Position("Senior разработчик", 2, 95000));
        devDepartment.addPosition(new Position("Junior разработчик", 1, 50000));

        Department supportDepartment = new Department("IT-SUP-001", "Отдел технической поддержки");
        supportDepartment.addPosition(new Position("Руководитель отдела поддержки", 1, 85000));
        supportDepartment.addPosition(new Position("Специалист технической поддержки", 2, 55000));

        itDepartment.addSubDepartment(devDepartment);
        itDepartment.addSubDepartment(supportDepartment);

        Department salesDepartment = new Department("SALES-001", "Отдел продаж");
        salesDepartment.addPosition(new Position("Директор по продажам", 1, 110000));
        salesDepartment.addPosition(new Position("Менеджер по продажам", 3, 60000));

        company.addSubDepartment(itDepartment);
        company.addSubDepartment(salesDepartment);

        System.out.println("ПОЛНАЯ ОРГАНИЗАЦИОННАЯ СТРУКТУРА ПРЕДПРИЯТИЯ");
        System.out.println();
        company.printStaffing(0);

        System.out.println();
        System.out.println("ДОБАВЛЕНИЕ НОВОЙ ДОЛЖНОСТИ В ОТДЕЛ РАЗРАБОТКИ");
        System.out.println();
        devDepartment.addPosition(new Position("DevOps инженер", 1, 90000));
        devDepartment.printStaffing(0);

        System.out.println();
        System.out.println("УДАЛЕНИЕ ДОЛЖНОСТИ ИЗ ОТДЕЛА ПОДДЕРЖКИ");
        System.out.println("Удаляем должность: Специалист технической поддержки");
        System.out.println();
        supportDepartment.removePosition("Специалист технической поддержки");
        supportDepartment.printStaffing(0);

        System.out.println();
        System.out.println("ИТОГОВАЯ СТАТИСТИКА ПО ПРЕДПРИЯТИЮ");
        System.out.println();
        System.out.println("Общее количество штатных единиц: " +
                String.format("%.2f", company.getTotalStaffUnits()));
        System.out.println("Общий фонд оплаты труда: " +
                String.format("%.2f", company.getTotalSalary()) + " руб.");
        System.out.println();
    }
}