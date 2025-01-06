package hw.oop;

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
public class PersonWithAParent {
    private final Name name;
    private PersonWithAParent father;



    // 1.4.6
    // Реализуйте описанные способы создания Человека таким образом,
    // чтобы операции присвоения использовались только в одном из конструкторов.
    public PersonWithAParent(String personalName) { // 1.4.6
        this.name = new Name(personalName);
    }

    public PersonWithAParent(Name name) {// 1.4.6
        this.name = name;
    }

    public PersonWithAParent(PersonWithAParent father, String personalName) { // 1.4.6
        this.father = father;
        this.name = new Name(personalName);
    }

    public PersonWithAParent(PersonWithAParent father, Name name) { // 1.4.6
        this.father = father;
        this.name = name;
    }


    // 1.6.7
    public PersonWithAParent getFather() {
        if (father == null)
            throw new IllegalArgumentException("Отец не указан");
        // Создал копию поля отец у объекта
        if (father.father == null)
            return new PersonWithAParent(father.name);
        else return new PersonWithAParent(father.father, father.name);
    }

    // 1.6.7 - поле name final, поэтому можно безопасно его возвращать
    public Name getName() {
        return name;
    }



    // 1.5.4
    public String getPersonalName() {
        String personalName = name.personalName; // По конструкторам предполагается, что без имени нельзя создать объект
        if (personalName.isEmpty()) // поэтому npe не вылетит, когда стучимся в name
            throw new IllegalArgumentException("Личное имя не указано");
        return personalName;
    }
    // 1.5.4
    public String getPatronymic() {
        String patronymic = name.patronymic;
        if (patronymic.isEmpty())
            throw new IllegalArgumentException("Отчество не указано");
        return patronymic;
    }
    // 1.5.4
    public String getSurname() {
        String surname = name.surname;
        PersonWithAParent fatherCopy = father;
        while (surname == null) {
            if (fatherCopy != null) {
                if (fatherCopy.name.surname == null)
                    fatherCopy = fatherCopy.father;
                else surname = fatherCopy.name.surname;
            } else throw new IllegalArgumentException("Нет фамилии у родни или про нее ничего неизвестно");
        }
        return surname;
    }

    // Переделал метод под 1.5.4
    @Override
    public String toString() {
        if (name.patronymic == null && father != null && father.getPersonalName() != null)
            return getSurname() +  " " +  this.getPersonalName() + " " + father.getPersonalName() + "ович";
        return getSurname() +  " " + getPersonalName();
    }
}



