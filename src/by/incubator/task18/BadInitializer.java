package by.incubator.task18;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BadInitializer<T> extends Initializer<T> {
    static <T> T initialize(T target, String fieldName, Object value) {
        Class<?> clazz = target.getClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No such field in clazz");
        }

        field.setAccessible(true);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return target;
    }
}