package by.incubator.task18;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory<T> {
    static <T> T create(Class<T> clazz) {
        if (ClazzUtils.validate(clazz)) {
            try {
                Constructor constructor = clazz.getConstructor();

                try {
                    return (T) constructor.newInstance();
                } catch (InstantiationException |
                        IllegalAccessException |
                        InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class must have default constructor");
            }
        }

        throw new IllegalArgumentException("Class must have getters and setters");
    }
}