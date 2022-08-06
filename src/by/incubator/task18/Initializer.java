package by.incubator.task18;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Initializer<T> {
    static <T> T initialize(T target, String fieldName, Object value) {
        Class<?> clazz = target.getClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No such field in clazz");
        }

        String setterName = ClazzUtils.deriveSetterNameFromFieldName(field);

        Method methodSetter = null;
        try {
            methodSetter = clazz.getMethod(setterName, field.getType());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No suitable Setter in clazz");
        }

        try {
            methodSetter.invoke(target, value);
        } catch (IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

        return target;
    }
}