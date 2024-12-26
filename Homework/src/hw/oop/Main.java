package hw.oop;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1.1.1
        System.out.println("1.1.1");
        Point point = new Point();
        point.x = 1;
        point.y = 1;
        Point point2 = new Point();
        point2.x = 2;
        point2.y = 2;
        Point point3 = new Point();
        point3.x = 3;
        point3.y = 3;
        System.out.println(point);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println("------------");

        // 1.1.2
        System.out.println("1.1.2");
        Person person = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person.name = "Клеопатра";
        person.height = 152;
        person2.name = "Пушкин";
        person2.height = 167;
        person3.name = "Александр";
        person3.height = 189;
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println("------------");

        // 1.1.3
        System.out.println("1.1.3");
        Name kleopatra = new Name();
        kleopatra.personalName = "Клеопатра";
        Name pushkin = new Name();
        pushkin.surname = "Пушкин";
        pushkin.personalName = "Александр";
        pushkin.patronymic = "Сергеевич";
        Name mayakovsky = new Name();
        mayakovsky.surname = "Маяковский";
        mayakovsky.personalName = "Владимир";
        System.out.println(kleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
        System.out.println("------------");

        // 1.1.4
        System.out.println("1.1.4");
        Time time = new Time();
        time.seconds = 10;
        Time time2 = new Time();
        time2.seconds = 10_000;
        Time time3 = new Time();
        time3.seconds = 100_000;
        System.out.println(time);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println("------------");

        // 1.1.5
        System.out.println("1.1.5");
        House house = new House();
        house.numberOfFloors = 1;
        House house2 = new House();
        house2.numberOfFloors = 5;
        House house3 = new House();
        house3.numberOfFloors = 23;
        System.out.println(house);
        System.out.println(house2);
        System.out.println(house3);
        System.out.println("------------");

        // 1.2.1
        System.out.println("1.2.1");
        Point point4 = new Point();
        point4.x = 1;
        point4.y = 3;
        Point point5 = new Point();
        point5.x = 23;
        point5.y = 8;
        Point point6 = new Point();
        point6.x = 10;
        point6.y = 5;
        Point point7 = new Point();
        point7.x = 10;
        point7.y = 25;

        Line line = new Line();
        line.startPoint = point4;
        line.endPoint = point5;
        Line line2 = new Line();
        line2.startPoint = point6;
        line2.endPoint = point7;
        Line line3 = new Line();
        line3.startPoint = point4;
        line3.endPoint = point7;
        // Измените координаты первой и второй линий
        line.startPoint.x = 2;
        line.startPoint.y = 4;
        line.endPoint.x = 24;
        line.endPoint.y = 9;
        line2.startPoint.x = 11;
        line2.startPoint.y = 6;
        line2.endPoint.x = 11;
        line2.endPoint.y = 26;
        // Измените координаты первой линии так, чтобы при этом не изменились, координаты третьей линии
        line.endPoint.x = 25;
        line.endPoint.y = 10;

        // 1.2.2
        System.out.println("1.2.2");
        PersonWithName personWithNameKleopatra = new PersonWithName();
        personWithNameKleopatra.name = kleopatra;
        personWithNameKleopatra.height = 152;
        PersonWithName personWithNamePushkin = new PersonWithName();
        personWithNamePushkin.name = pushkin;
        personWithNamePushkin.height = 167;
        PersonWithName personWithNameMayakovsky = new PersonWithName();
        personWithNameMayakovsky.name = mayakovsky;
        personWithNameMayakovsky.height = 189;
        System.out.println(personWithNameKleopatra);
        System.out.println(personWithNamePushkin);
        System.out.println(personWithNameMayakovsky);
        System.out.println("------------");

        // 1.2.3
        System.out.println("1.2.3");
        Name nameIvan = new Name();
        nameIvan.surname = "Чудов";
        nameIvan.personalName = "Иван";
        PersonWithAParent ivan = new PersonWithAParent();
        ivan.name = nameIvan;

        Name namePetr = new Name();
        namePetr.surname = "Чудов";
        namePetr.personalName = "Петр";
        PersonWithAParent peter = new PersonWithAParent();
        peter.name = namePetr;
        peter.father = ivan;

        Name nameBoris = new Name();
        nameBoris.personalName = "Борис";
        PersonWithAParent boris = new PersonWithAParent();
        boris.name = nameBoris;
        boris.father = peter;

        System.out.println(ivan);
        System.out.println(peter);
        System.out.println(boris);
        System.out.println("------------");

        // 1.2.4
        System.out.println("1.2.4");
        // Создание отдела IT
        Department itDepartment = new Department();
        itDepartment.name = "IT";
        itDepartment.employees = new Employee[10]; // 1.3.4 Создадим сначала в отделе свободные места для потенциальных сотрудников
        // Создание сотрудников
        Employee petrov = new Employee();
        petrov.name = "Петров";
        petrov.department = itDepartment; // Петрову говорим, что он работает теперь в IT отделе
        itDepartment.employees[0] = petrov; // 1.3.4 В отделе закрепляем место за Петровым

        Employee kozlov = new Employee();
        kozlov.name = "Козлов";
        kozlov.department = itDepartment;
        itDepartment.employees[1] = kozlov; // Аналогично

        Employee sidorov = new Employee();
        sidorov.name = "Сидоров";
        sidorov.department = itDepartment;
        itDepartment.employees[2] = sidorov; // Аналогично

        // Назначение начальника отдела
        itDepartment.chief = kozlov;

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
        System.out.println("------------");

        // 1.3.1
        System.out.println("1.3.1");
        Student vasa = new Student();
        int[] marksVasa = new int[] {3, 4, 5};
        vasa.name = "Вася";
        vasa.marks = marksVasa;

        Student peta = new Student();
        peta.name = "Петя";
        peta.marks = marksVasa;

        peta.marks[0] = 5; // Оценки будут совпадать, т.к. это один объект массива. Вася и Петя на него просто ссылаются
        Student andrey = new Student();
        andrey.name = "Андрей";
        andrey.marks = Arrays.copyOf(peta.marks, peta.marks.length); // Новый массив оценок. Изменения у одного теперь не влияют на другого
        System.out.println("------------");

        // 1.3.2
        System.out.println("1.3.2");
        Point firstPoint = new Point();
        firstPoint.x = 1;
        firstPoint.y = 5;
        Point secondPoint = new Point();
        secondPoint.x = 2;
        secondPoint.y = 8;
        Point treePoint = new Point();
        treePoint.x = 5;
        treePoint.y = 3;

        Point[] points = new Point[3];
        points[0] = firstPoint;
        points[1] = secondPoint;
        points[2] = treePoint;

        Polyline polyline = new Polyline(); // Создать первую Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}
        polyline.points = points;

        // Создайте вторую Ломаную, чья первая и последняя Точка совпадает с таковыми у первой Ломаной,
        //но в качестве середины имеет точки: {2,-5}, {4,-8}
        Point fourthPoint = new Point();
        fourthPoint.x = 2;
        fourthPoint.y = -5;

        Point fifthPoint = new Point();
        fifthPoint.x = 4;
        fifthPoint.y = -8;

        Point[] secondArrayPoints = new Point[]{points[0], fourthPoint, fifthPoint, points[2]};

        Polyline polyline2 = new Polyline();
        polyline2.points = secondArrayPoints;

        // Сдвиньте начало первой Ломаной таким образом, чтобы одновременно сдвинулось начало второй Ломаной.
        points[0].x = 2;
        points[0].y = 6;
        System.out.println("------------");

        // 1.3.3
        City cityA = new City("A");
        cityA.name = "A";
        City cityB = new City("B");
        cityB.name = "B";
        City cityC = new City("C");
        cityC.name = "C";
        City cityD = new City("D");
        cityD.name = "D";
        City cityE = new City("E");
        cityE.name = "E";
        City cityF = new City("F");
        cityF.name = "F";

        Way wayFromAToB = new Way();
        wayFromAToB.city = cityB;
        wayFromAToB.price = 5;

        Way wayFromBToA = new Way();
        wayFromBToA.city = cityA;
        wayFromBToA.price = 5;


        Way wayFromAToF = new Way();
        wayFromAToF.city = cityF;
        wayFromAToF.price = 1;

        Way wayFromAToD = new Way();
        wayFromAToD.city = cityD;
        wayFromAToD.price = 6;

        Way wayFromDToA = new Way();
        wayFromDToA.city = cityA;
        wayFromDToA.price = 6;

        Way wayFromBToC = new Way();
        wayFromBToC.city = cityC;
        wayFromBToC.price = 3;

        Way wayFromCToB = new Way();
        wayFromCToB.city = cityB;
        wayFromCToB.price = 3;

        Way wayFromFToB = new Way();
        wayFromFToB.city = cityB;
        wayFromFToB.price = 1;

        Way wayFromFToE = new Way();
        wayFromFToE.city = cityE;
        wayFromFToE.price = 5;

        Way wayFromEToF = new Way();
        wayFromEToF.city = cityF;
        wayFromEToF.price = 2;

        Way wayFromCToD = new Way();
        wayFromCToD.city = cityD;
        wayFromCToD.price = 4;

        Way wayFromDToC = new Way();
        wayFromDToC.city = cityC;
        wayFromDToC.price = 4;

        Way wayFromDToE = new Way();
        wayFromDToE.city = cityE;
        wayFromDToE.price = 2;

        cityA.ways = new Way[] {wayFromAToB, wayFromAToD, wayFromAToF};
        cityB.ways = new Way[] {wayFromBToC, wayFromBToA};
        cityC.ways = new Way[] {wayFromCToD, wayFromCToB};
        cityD.ways = new Way[] {wayFromDToA, wayFromDToC, wayFromDToE};
        cityE.ways = new Way[] {wayFromEToF};
        cityF.ways = new Way[] {wayFromFToE, wayFromFToB};
        System.out.println(cityF);
        System.out.println("------------");

        // 1.3.4
        System.out.println("1.3.4");
        // Будут null-ы, типо оставшиеся свободные места в отделе. Как сделать лучше, чтобы код был небольшим и без коллекция - не догадался
        System.out.println(Arrays.toString(petrov.department.employees));
        System.out.println("------------");

        // 1.4.1
        System.out.println("1.4.1");
        Point pointNew = new Point(3, 5);
        Point pointNew2 = new Point(25, 6);
        Point pointNew3 = new Point(7, 8);
        System.out.println(pointNew);
        System.out.println(pointNew2);
        System.out.println(pointNew3);
        System.out.println("------------");

        // 1.4.2
        System.out.println("1.4.2");
        Line line4 = new Line(new Point(1, 3), new Point(23, 8));
        Line line5 = new Line(new Point(5, 10), new Point(25, 10));
        Line line6 = new Line(line4.startPoint, line5.endPoint);
        System.out.println("------------");

        // 1.4.3
        System.out.println("1.4.3");
        Point[] points2 = new Point[]{
                new Point(3,5),
                new Point(25,6),
                new Point(7,8)};
        Polyline poly = new Polyline(points2);
        System.out.println("------------");

        // 1.4.4
        System.out.println("1.4.4");
        House house4 = new House(2);
        House house5 = new House(35);
        House house6 = new House(91);
        // house6.numberOfFloors = 93; с полем помеченным final будет ошибка
        System.out.println("------------");


        // 1.4.5
        System.out.println("1.4.5");
        Name nameNewKleopatra = new Name("Клеопатра");
        Name nameNewPushkin = new Name("Александр", "Пушкин", "Сергеевич");
        Name nameNewMayakovsky = new Name("Владимир", "Маяковский");
        Name nameNewHristofer = new Name("Христофор", "Бонифатьевич");
        System.out.println(nameNewKleopatra);
        System.out.println(nameNewPushkin);
        System.out.println(nameNewMayakovsky);
        System.out.println(nameNewHristofer);
        System.out.println("------------");

        // 1.4.6
        System.out.println("1.4.6");
        PersonWithAParent lev = new PersonWithAParent("Лев");

        PersonWithAParent pushkinSergey = new PersonWithAParent(
                lev,
                new Name("Сергей", "Пушкин"));

        PersonWithAParent alexandr = new PersonWithAParent(
                pushkinSergey,
                "Александр");

        System.out.println(lev);
        System.out.println(pushkinSergey);
        System.out.println(alexandr);
        System.out.println("------------");

        // 1.4.7
        System.out.println("1.4.7");
        int[] marks = new int[] {3, 4, 5};
        Student studentVasa = new Student("Вася", marks);
        Student studentMax = new Student("Максим");
        System.out.println(studentVasa);
        System.out.println(studentMax);
        System.out.println("------------");


    }
}
