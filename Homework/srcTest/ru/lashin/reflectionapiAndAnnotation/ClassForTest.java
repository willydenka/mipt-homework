package ru.lashin.reflectionapiAndAnnotation;

import ru.lashin.reflectionapiAndAnnotation.entity.Entity;
import ru.lashin.reflectionapiAndAnnotation.entity.ToString;
import ru.lashin.reflectionapiAndAnnotation.methods.Value;

@ToString
public class ClassForTest extends Entity {
    @ToString(Value.NO)
    String string = "hello";
    int integer = 42;
}
