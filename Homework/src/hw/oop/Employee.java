package hw.oop;

public class Employee {
    private final String name;
    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (this.department != null) { // Если у текущего сотрудника есть какой-то отдел
           if (this.department.getEmployees().contains(this)) // И в этом отделе он среди сотрудников
               this.department.removeEmployeeFromThisDepartment(this); // Убираем его из сотрудников
       }
       this.department = department; // Присваивам текущему сотруднику входной отдел или нул
       if (department != null && !department.getEmployees().contains(this)) // Если входной отдел не нул и текущий сотрудник не в его списке
           department.addEmployee(this); // Добавляем текущего сотрудника в список
    }

    @Override
    public String toString() {
        if (department == null)
            return name + " не работает";
        if (this == department.getBoss())
            return name + ", начальник отдела " + department.getName();
        return name + ", " + department;
    }
}

