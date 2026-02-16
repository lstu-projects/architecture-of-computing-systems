package ru.danilscheglov;

/**
 * Класс для представления должности в штатном расписании
 */
public class Position {

    private String title;
    private double staffUnits;
    private double salary;

    public Position(String title, double staffUnits, double salary) {
        this.title = title;
        this.staffUnits = staffUnits;
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getStaffUnits() {
        return staffUnits;
    }

    public void setStaffUnits(double staffUnits) {
        this.staffUnits = staffUnits;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Расчет общей суммы окладов для данной должности
     */
    public double getTotalSalary() {
        return staffUnits * salary;
    }

    @Override
    public String toString() {
        return String.format("%-30s | Ставок: %.2f | Оклад: %.2f руб. | Сумма: %.2f руб.", title, staffUnits, salary, getTotalSalary());
    }
}
