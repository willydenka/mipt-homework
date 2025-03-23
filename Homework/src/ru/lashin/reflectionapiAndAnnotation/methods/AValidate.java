package ru.lashin.reflectionapiAndAnnotation.methods;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Validate({NameTest.class, AgeTest.class})
public @interface AValidate {
}
