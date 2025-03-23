package ru.lashin.streams;
import ru.lashin.geometry.Point;
import ru.lashin.geometry.Polyline;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // task 1
        List<Point> listPoints = new ArrayList<>(List.of(
                new Point(-5,1),
                new Point(3,3),
                new Point(2,-10),
                new Point(4,-4),
                new Point(3,3)
        ));
        Polyline polyline = listPoints.stream()
                .distinct()
                .sorted(Comparator.comparingInt(currentPoint -> currentPoint.x))
                .map(point -> new Point(point.x, Math.abs(point.y)))
                .collect(Polyline::new,
                        Polyline::addPoints,
                        (sb1, sb2) -> sb1.addPoints(sb2.getPoints()));
        System.out.println(polyline);

        // task 2
        List<String> listStrings = new ArrayList<>(List.of("Петя:3", "вася:5", "Аня:5", "Коля:"));
        Map<Integer, List<String>> res = listStrings.stream()
                .map(string -> (string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase()).split(":"))
                .filter(array -> array.length != 1)
                .collect(Collectors.groupingBy(array ->
                                Integer.parseInt(array[1]),
                                Collectors.mapping(array -> array[0], Collectors.toList())));
        System.out.println(res);
    }
}
