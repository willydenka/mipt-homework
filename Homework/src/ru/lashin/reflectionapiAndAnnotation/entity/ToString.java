package ru.lashin.reflectionapiAndAnnotation.entity;

import ru.lashin.reflectionapiAndAnnotation.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    Value value() default Value.YES;
}

