package hw.until24thDecember;
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
    String name;
    Department department;


    @Override
    public String toString() {
        if (department != null) {
            if (this == department.chief) {
                return name + " начальник отдела " + (department.name != null ? department.name : "без названия");
            } else {
                String chief = department.chief != null ? department.chief.name : "неизвестен";
                return name + " работает в отделе " + (department.name != null ? department.name : "без названия")
                        + ", начальник которого " + chief;
            }
        }
        return name + " не имеет отдела";
    }
}
