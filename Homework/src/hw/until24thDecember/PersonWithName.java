package hw.until24thDecember;
/*
Ранее нами был реализован сущностью Человек (1.1.2), в котором присутствовало
поле для указания имени, задававшееся строкой. Измените тип этого поля таким образом,
чтобы оно задавалось сущностью Имя из задачи 1.1.3.
Необходимо создать и вывести на экран текстовое представление следующих людей:
•	Человека с Именем Клеопатра и ростом 152
•	Человека с Именем Пушкин Александр Сергеевич и ростом 167
•	Человека с Именем Маяковский Владимир и ростом 189
 */
public class PersonWithName {
    Name name;
    int height;

    public PersonWithName() {}

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}
