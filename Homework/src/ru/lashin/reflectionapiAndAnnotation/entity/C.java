package ru.lashin.reflectionapiAndAnnotation.entity;

import ru.lashin.reflectionapiAndAnnotation.methods.Value;
@ToString
class C extends Entity {
    String str = "hello";
    @ToString(Value.NO)
    int y = 42;
}
