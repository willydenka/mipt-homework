package hw.until24thDecember;
/*
Создайте сущность Время, которое будет описывать текущее время суток в 24-х часовом формате.
Время описывается числом секунд, прошедшим с начала суток. Время может быть приведено к
текстовой форме следующего формата: “ЧЧ:ММ:СС”. Например, если время задано как 12000,
то текстовая форма будет “3:20:00”. Если общее время превышает 24 часа, то отображаться в
текстовом виде должно только то время, которое прошло с начала последних суток, например
91800, это не 25:30:00, а 1:30:00.
Необходимо создать и вывести на экран текстовую форму для следующих вариантов времени:
•	10 секунд
•	10000 секунд
•	100000 секунд
 */
public class Time {
    int seconds;

    public Time(){}


    @Override
    public String toString() {
        int hours;
        int minutes;
        int secondsTemp;
        int tmp = seconds;

        if (seconds < 0)
            throw new IllegalArgumentException();
        if (seconds > 86400)
            tmp = seconds-86400;

        hours = tmp/3600; // 1
        minutes = (tmp-3600*hours)/60; // 35
        secondsTemp = (tmp-3600*hours)-(60*minutes); // 10
        return hours + ":" + minutes + ":" + secondsTemp;
    }
}
