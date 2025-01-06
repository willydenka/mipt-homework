package hw.oop;

/*
Создайте сущность Сотрудник, которая описывается:
•	Имя: строка
•	Отдел: включает название (строка) и начальника (Сотрудник)
Сотрудник может быть приведен к текстовой форме вида:
“Имя работает в отделе Название, начальник которого Имя”.
В случае если сотрудник является руководителем отдела, то текстовая форма должна быть “Имя начальник отдела Название”.
Предусмотрите при приведении Сотрудника к строковой форме,
что у Сотрудника может быть не указан отдел, название отдела, и начальник отдела.
Необходимо выполнить следующие задачи:
1.	Создать Сотрудников Петрова, Козлова, Сидорова работающих в отделе IT.
2.	Сделать Козлова начальником IT отдела.
3.	Вывести на экран текстовое представление всех трех Сотрудников
(у всех троих должен оказаться один и тот же отдел и начальник).
 */
public class Employee {
    private final String name;
    private Department department;

    public Employee(String name) {
        this(name, null);
    }
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        if (department != null && !department.getEmployees().contains(this))
            department.addEmployee(this);
    }

    public void setDepartment(Department department) {
        this.department = department;
        if (!department.getEmployees().contains(this))
            department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if (department == null)
            return name + " не работает";
        if (this == department.getChief())
            return name + ", начальник отдела " + department.getName();
        return name + ", " + department;
    }
}

