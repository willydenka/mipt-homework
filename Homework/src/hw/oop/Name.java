package hw.oop;
/*
Создайте сущность Имя, которая описывается тремя параметрами:
•	Фамилия: строка
•	Личное имя: строка
•	Отчество: строка
Имя может быть приведено к строковому виду, включающему традиционное представление всех трех параметров:
Фамилия Имя Отчество (например “Иванов Иван Иванович”). Необходимо предусмотреть возможность того,
что какой-либо из параметров может быть не задан, и в этом случае он не учитывается в итоговом тексте.
Необходимо создать и вывести на экран текстовое представление следующих имен:
•	Клеопатра
•	Пушкин Александр Сергеевич
•	Маяковский Владимир
 */
public class Name {
    String surname;
    String personalName;
    String patronymic;

    public Name() {}


    // 1.4.5
    public Name(String personalName) {
        this.personalName = personalName;
    }

    public Name(String personalName, String surname) {
        this(personalName);
        this.surname = surname;
    }

    public Name(String personalName, String surname, String patronymic) {
        this(personalName, surname);
        this.patronymic = patronymic;
    }


    @Override
    public String toString() {
        String result = "";
        if (surname != null)
            result += surname;
        if (personalName != null) {
            if (!result.isEmpty())
                result += " ";
            result += personalName;
        }
        if (patronymic != null) {
            if (!result.isEmpty())
                result += " ";
            result += patronymic;
        }
    return result;
    }
}
