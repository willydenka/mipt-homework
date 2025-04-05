package ru.lashin.reflectionapiAndAnnotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.lashin.reflectionapiAndAnnotation.entity.Entity;
import ru.lashin.reflectionapiAndAnnotation.entity.ToString;
import ru.lashin.reflectionapiAndAnnotation.methods.Value;

import java.util.HashMap;
import java.util.Map;

public class EntityTest {
    @ToString
    static class ClassYesTest extends Entity {
        @ToString(Value.NO)
        String name = "petya";
        int age = 24;
    }

    @ToString(Value.NO)
    static class ClassNoTest extends Entity {
        @ToString(Value.YES)
        String name = "petya";
        int age = 24;
    }

    @ToString
    static class ExtendedClass extends ClassYesTest {
        String name = "vasya";
        int age = 42;
    }

    @Test
    public void simpleNameTest() {
        ClassYesTest classYesTest = new ClassYesTest();
        String actual = classYesTest.toString().split("\\{")[0];
        Assertions.assertEquals("ClassYesTest", actual);
    }

    @Test
    public void parentTest() {
        ExtendedClass actualClass = new ExtendedClass();
        Assertions.assertEquals("ExtendedClass{name=vasya, age=42, age=24}", actualClass.toString());
    }

    @Test
    public void fieldNoTest() {
        ClassYesTest classYesTest = new ClassYesTest();
        String actual = classYesTest.toString();
        Assertions.assertEquals("ClassYesTest{age=24}", actual);
    }

    @Test
    public void fieldYesTest() {
        ClassNoTest classNoTest = new ClassNoTest();
        String actual = classNoTest.toString();
        Assertions.assertEquals("ClassNoTest{name=petya}", actual);
    }
}
