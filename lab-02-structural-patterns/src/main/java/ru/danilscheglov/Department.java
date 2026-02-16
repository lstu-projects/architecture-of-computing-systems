package ru.danilscheglov;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Department (Композит) - представляет подразделение,
 * которое может содержать другие подразделения и должности
 */
public class Department extends OrganizationalComponent {
    private List<OrganizationalComponent> subDepartments;
    private List<Position> positions;

    public Department(String code, String name) {
        super(code, name);
        this.subDepartments = new ArrayList<>();
        this.positions = new ArrayList<>();
    }

    @Override
    public void addSubDepartment(OrganizationalComponent component) {
        subDepartments.add(component);
    }

    @Override
    public void removeSubDepartment(OrganizationalComponent component) {
        subDepartments.remove(component);
    }

    @Override
    public List<OrganizationalComponent> getSubDepartments() {
        return new ArrayList<>(subDepartments);
    }

    @Override
    public void addPosition(Position position) {
        positions.add(position);
    }

    @Override
    public void removePosition(String positionTitle) {
        positions.removeIf(p -> p.getTitle().equals(positionTitle));
    }

    @Override
    public List<Position> getPositions() {
        return new ArrayList<>(positions);
    }

    /**
     * Расчет общего количества штатных единиц
     * (включая все подчиненные подразделения)
     */
    @Override
    public double getTotalStaffUnits() {
        double total = 0;

        for (Position position : positions) {
            total += position.getStaffUnits();
        }

        for (OrganizationalComponent subDept : subDepartments) {
            total += subDept.getTotalStaffUnits();
        }

        return total;
    }

    /**
     * Расчет суммарного оклада
     * (включая все подчиненные подразделения)
     */
    @Override
    public double getTotalSalary() {
        double total = 0;

        for (Position position : positions) {
            total += position.getTotalSalary();
        }

        for (OrganizationalComponent subDept : subDepartments) {
            total += subDept.getTotalSalary();
        }

        return total;
    }

    /**
     * Вывод штатного расписания для подразделения
     * и всех его подчиненных подразделений
     */
    @Override
    public void printStaffing(int level) {
        String indent = getIndent(level);

        // Выводим заголовок подразделения
        System.out.println(indent + "ПОДРАЗДЕЛЕНИЕ: " + name + " (Код: " + code + ")");

        // Выводим должности текущего подразделения
        if (!positions.isEmpty()) {
            System.out.println(indent + "Штатное расписание:");
            for (Position position : positions) {
                System.out.println(indent + "  " + position);
            }
        }

        double localStaffUnits = positions.stream()
                .mapToDouble(Position::getStaffUnits)
                .sum();
        double localSalary = positions.stream()
                .mapToDouble(Position::getTotalSalary)
                .sum();

        System.out.println(indent + "ИТОГО по подразделению:");
        System.out.println(indent + "  Штатных единиц: " + String.format("%.2f", localStaffUnits));
        System.out.println(indent + "  Фонд оплаты труда: " + String.format("%.2f", localSalary) + " руб.");

        if (!subDepartments.isEmpty()) {
            System.out.println(indent + "ИТОГО с подчиненными подразделениями:");
            System.out.println(indent + "  Штатных единиц: " + String.format("%.2f", getTotalStaffUnits()));
            System.out.println(indent + "  Фонд оплаты труда: " + String.format("%.2f", getTotalSalary()) + " руб.");
        }

        System.out.println();

        for (OrganizationalComponent subDept : subDepartments) {
            subDept.printStaffing(level + 1);
        }
    }
}