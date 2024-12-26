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
    Name name;
    PersonWithAParent father;

    public PersonWithAParent(){}

    // 1.4.6
    // Реализуйте описанные способы создания Человека таким образом,
    // чтобы операции присвоения использовались только в одном из конструкторов.
    public PersonWithAParent(String personalName){ // 1.4.6
        this.name = new Name(personalName);
    }

    public PersonWithAParent(Name name){ // 1.4.6
        this.name = name;
    }

    public PersonWithAParent(PersonWithAParent father, String personalName){ // 1.4.6
        this.father = father;
        this.name = new Name(personalName);
    }

    public PersonWithAParent(PersonWithAParent father, Name name){ // 1.4.6
        this.father = father;
        this.name = name;
    }

    @Override
    public String toString() {
            if (name.surname == null && father != null &&  father.name.surname != null)
                return father.name.surname + " " + name;

            if (name.patronymic == null && father != null && father.name.personalName != null)
                return name + " " + father.name.personalName + "ович";

            return name.toString();
    }
}
