package ru.lashin.reflectionapiAndAnnotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class EntityTest {
    @Test
    public void toStringTest() {
        ClassForTest test = new ClassForTest();

        Map<String, Object> map = new HashMap<>();
        map.put("integer", 42);
        Assertions.assertEquals(test.toString(), map.toString());

    }
}
