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
    private final String surname;
    private final String personalName;
    private final String patronymic;


    // 1.4.5 + 1.6.2
    public Name(String personalName) {
        this(personalName, "", "");
    }

    public Name(String personalName, String surname) {
        this(personalName, surname, "");
    }

    public Name(String personalName, String surname, String patronymic) {
        if (personalName == null) personalName = "";
        if (surname == null) surname = "";
        if (patronymic == null) patronymic = "";

        if (personalName.isEmpty() && surname.isEmpty() && patronymic.isEmpty())
            throw new IllegalArgumentException("Имя не должно быть пустым");
        this.personalName = personalName;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalName() {
        return personalName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        String result = surname + " " + personalName + " " + patronymic;
        return result.trim();
    }
}



