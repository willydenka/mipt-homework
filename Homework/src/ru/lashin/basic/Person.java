package ru.lashin.basic;

/*
Измените сущность Человек из задачи 1.2.2 добавив ему возможность задавать третий параметр: Отец, где Отец — это тоже Человек.
При приведении человека к строковой форме необходимо выполнить следующие действия:
•	Личное имя берется по прежним правилам
•	Если Фамилия в Имени НЕ указана, то вместо неё используется Фамилия Отца. Если Отец не указан, или не имеет Фамилии,
то Фамилия в строковой форме не участвует.
•	Если Отчество в Имени не указано, то вместо неё используется Имя Отца с добавлением окончания “-ович”.
Если Отец не указан, или не имеет Имени, то Имя в строковой форме не участвует
•	Исключите информацию о росте Человека из строковой формы.
Обратите внимание, что никакие действия, выполняемые при приведении к строке, не должны повлиять
не изменение состояния текущего объекта.

Необходимо выполнить следующие задачи:
1.	Создать людей: Чудова Ивана, Чудова Петра, Бориса
2.	Сделать Ивана отцом Петра, а Петра отцом Бориса
3.	Вывести на экран строковое представление всех троих людей.
 */
public class Person {
    private final Name name;
    private final Person father;
    // 1.4.6
    // Реализуйте описанные способы создания Человека таким образом,
    // чтобы операции присвоения использовались только в одном из конструкторов.
    public Person(String personalName) { // 1.4.6
        this(null, new Name(personalName));
    }

    public Person(Name name) {// 1.4.6
        this(null, name);
    }

    public Person(Person father, String personalName) { // 1.4.6
        this(father, new Name(personalName));
    }

    public Person(Person father, Name name) { // 1.4.6
        this.father = father;
        if (name == null)
            name = new Name("");
        this.name = name;
    }

    // 1.6.7
    public Person getFather() {
        return father; // Возвращаем напрямую, так как сам класс неизменяемый (нет сеттеров, все поля private final)
    }
    // 1.6.7 - поле name final, поэтому можно безопасно его возвращать
    public Name getName() {
        return name;
    }
    // 1.5.4
    public String getPersonalName() {
        return name.getPersonalName();
    }
    // 1.5.4
    public String getPatronymic() {
        if (father == null) return null;
        String patronymic = name.getPatronymic();
        if (patronymic.isBlank())
            patronymic = father.getPersonalName() + "ович";
        return patronymic;
    }
    // 1.5.4
    public String getSurname() {
        String surname = name.getSurname();
        Person fatherCopy = father;
        while (surname == null) {
            if (fatherCopy != null) {
                if (fatherCopy.name.getSurname() == null)
                    fatherCopy = fatherCopy.father;
                else surname = fatherCopy.name.getSurname();
            } else break;
        }
        return surname;
    }

    // Переделал метод под 1.5.4
    @Override
    public String toString() {
        return new Name(getSurname(), getPersonalName(), getPatronymic()).toString();
    }
}