package ru.lashin.reflectionapiAndAnnotation.invoke;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
    String value() default "";
}
