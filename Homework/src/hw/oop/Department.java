package hw.oop;
import java.util.ArrayList;

public class Department {
    private final String name;
    private Employee boss;
    private final ArrayList<Employee> employees = new ArrayList<>();


    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addEmployee(Employee employee) {
        if (employee == null) return; // Если нул на вход, ничего не делаем
        if (employee.getDepartment() != null) // Если есть какой-то отдел у входного сотрудника
            employee.getDepartment().removeEmployeeFromThisDepartment(employee); // Удаляем из списка какого-то отдела входного сотрудника

        this.employees.add(employee); // Если у входного сотротдела не было отдела, то добавляем в список текущего отдела
        if (employee.getDepartment() != this) // Если отдел у входного сотрудника не равен текущему
            employee.setDepartment(this); // Устанавливаем входному сотруднику текущий отдел
    }

    public void setBoss(Employee boss) {
        if (boss != null) {
            if (this.boss != boss) { // Если входной сотрудник уже босс этого отдела, ничего не делаем
                boss.setDepartment(this); // Устанавливаем боссу отдел
                this.boss = boss; // Устанавливаем босса
            }
        } else this.boss = null;
    }

    // Служебный метод для удаления ТОЛЬКО входного сотрудника из отдела, на котором вызван метод
    public void removeEmployeeFromThisDepartment(Employee employee) {
        if (employee == null) return;
        if (employees.contains(employee)) {
            if (boss == employee) boss = null; // Если входной сотрудник был боссом, то зануляем
            employees.remove(employee);
        }
    }

    @Override
    public String toString() {
        String name = this.name;
        if (name == null || name.isBlank())
            name = "непонятно что";
        if (boss == null)
            return name + ", без начальника";

        String chiefName = this.boss.getName();
        if (chiefName == null || chiefName.isBlank())
            chiefName = "непонятно кто";
        return name + ", начальник которого " + chiefName;
    }
}
