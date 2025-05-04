package ru.lashin.mvc.DAO;

import org.springframework.stereotype.Component;
import ru.lashin.db.Column;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DAO {
    Set<String> namesTables = Set.of("Department", "Employee");

    private static class ColumnAnnotationProcessor {
        private static <T> void join(T t, ResultSet resultSet)
                throws SQLException, IllegalAccessException {
            // Через аннотайшен процессор связал поля с названиями колонок в таблице
            // Если поле аннотации равно названию колонке, то рефлексивно записываем значение
            ResultSetMetaData metaData = resultSet.getMetaData();
            Field[] fields = t.getClass().getDeclaredFields();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    Column column = field.getAnnotation(Column.class);
                    if (column.columnName().equals(metaData.getColumnName(i))) {
                        field.set(t, resultSet.getObject(i));
                        break;
                    }
                }
            }
        }

    }
    public<T> List<T> findAll(Class<T> tClass) {
        // Здесь я пытаюсь защититься от инъекции, так как тут обычный statement
        // Типо в классе есть список таблиц, к которым разрешено обращаться
        String nameTable = tClass.getSimpleName();
        if (!namesTables.contains(nameTable)) throw new IllegalArgumentException("Таблицы с таким имненем в БД нет!");

        String url = "jdbc:h2:.\\Office";
        List<T> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from " + nameTable);
            while (resultSet.next()) {
                T t = tClass.getDeclaredConstructor().newInstance(); // Создал объект по входному классу
                ColumnAnnotationProcessor.join(t, resultSet);
                result.add(t);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e ) {
            e.printStackTrace();
        }
        return result;
    }
}
