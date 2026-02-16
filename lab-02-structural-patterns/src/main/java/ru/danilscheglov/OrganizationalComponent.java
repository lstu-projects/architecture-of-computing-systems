package ru.danilscheglov;

import java.util.List;

/**
 * Абстрактный класс-компонент для паттерна Компоновщик
 * Определяет общий интерфейс для подразделений
 */
public abstract class OrganizationalComponent {
    protected String code;
    protected String name;

    public OrganizationalComponent(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public abstract void addSubDepartment(OrganizationalComponent component);
    public abstract void removeSubDepartment(OrganizationalComponent component);
    public abstract List<OrganizationalComponent> getSubDepartments();

    public abstract void addPosition(Position position);
    public abstract void removePosition(String positionTitle);
    public abstract List<Position> getPositions();

    public abstract double getTotalStaffUnits();
    public abstract double getTotalSalary();

    // Метод для вывода штатного расписания
    public abstract void printStaffing(int level);

    /**
     * Вспомогательный метод для форматирования отступов
     */
    protected String getIndent(int level) {
        return "  ".repeat(level);
    }
}