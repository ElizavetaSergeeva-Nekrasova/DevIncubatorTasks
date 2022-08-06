package by.incubator.task18;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClazzUtils {
    public static boolean validate(Class clazz) {
        return validateSetters(clazz) &&
                validateGetters(clazz);
    }

    public static String deriveGetterNameFromFieldName(Field field) {
        String fieldName = field.getName();

        return "get" + String.valueOf(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1);
    }

    public static String deriveSetterNameFromFieldName(Field field) {
        String fieldName = field.getName();

        return "set" + String.valueOf(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1);
    }

    private static boolean validateGetters(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field :
                fields) {
            try {
                Method method = clazz.getMethod(deriveGetterNameFromFieldName(field), null);
            } catch (NoSuchMethodException e) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateSetters(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field :
                fields) {
            if (isFieldNotFinal(field)) {
                try {
                    Method method = clazz.getMethod(deriveSetterNameFromFieldName(field), field.getType());
                } catch (NoSuchMethodException e) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isFieldNotFinal(Field field) {
        return Modifier.isFinal(field.getModifiers());
    }
}