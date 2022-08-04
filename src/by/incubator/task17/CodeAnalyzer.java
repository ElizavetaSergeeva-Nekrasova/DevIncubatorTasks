package by.incubator.task17;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class CodeAnalyzer {
    public static void analyzeClass(Object o) {
        Class clazz = o.getClass();

        showName(clazz);
        showClassLoader(clazz);
        showInterfaces(clazz);
        showHierarchy(clazz);
        showFields(clazz);
        showConstructors(clazz);
        showMethods(clazz);
        showClassAnnotations(clazz);
    }

    private static void showName(Class clazz) {
        System.out.println("Class name: " + clazz.getSimpleName());
        System.out.println("------------------------------");
    }

    private static void showClassLoader(Class clazz) {
        System.out.println("Class class loader: " + clazz.getClassLoader());
        System.out.println("------------------------------");
    }

    private static void showInterfaces(Class clazz) {
        Class[] interfaces = clazz.getInterfaces();

        System.out.println("\t\t\tInterfaces: ");
        for (Class anInterface : interfaces) {
            System.out.println();
            showInterface(anInterface);
        }

        System.out.println("------------------------------");
    }

    private static void showHierarchy(Class clazz) {
        System.out.println("\t\t\tHierarchy: ");

        Class clazzWalker = clazz;
        while (clazzWalker != null) {
            System.out.println(clazzWalker.getSimpleName());
            clazzWalker = clazzWalker.getSuperclass();
        }

        System.out.println("------------------------------");
    }

    private static void showFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();

        System.out.println("\t\t\tFields of class: ");
        for (Field field:
             fields) {
            System.out.println();
            showField(field);
        }

        System.out.println("------------------------------");
    }

    private static void showConstructors(Class clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();

        System.out.println("\t\t\tConstructors of class: ");
        for (Constructor constructor:
             constructors) {
            System.out.println();
            showConstructor(constructor);
        }

        System.out.println("------------------------------");
    }

    private static void showMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("\t\t\tMethods of class: ");
        for(Method method: methods) {
            System.out.println();
            showMethod(method);
        }

        System.out.println("------------------------------");
    }

    private static void showClassAnnotations(Class clazz) {
        System.out.print("Class annotations:");
        showAnnotations(clazz);

        System.out.println("------------------------------");
    }

    private static void showInterface(Class anInterface) {
        System.out.println("Interface name: " + anInterface.getSimpleName());

        showInterfaceMethods(anInterface);
    }

    private static void showInterfaceMethods(Class anInterface) {
        Method[] methods = anInterface.getDeclaredMethods();

        System.out.println("Methods: ");
        for(Method method: methods) {
            System.out.println();
            showInterfaceMethod(method);
        }
    }

    private static void showMethod(Method method) {
        System.out.println("Name of method: " + method.getName());

        showReturnType(method);
        showModifiers(method);
        showParameters(method);
        showElementAnnotations(method);
    }

    private static void showInterfaceMethod(Method method) {
        System.out.println("Name of method: " + method.getName());

        showReturnType(method);
        showModifiers(method);
        showParameters(method);
    }

    private static void showField(Field field) {
        System.out.println("Name of field: " + field.getName());
        System.out.println("\ttype: " + field.getType().getSimpleName());
        showModifiers(field);
        showElementAnnotations(field);
    }

    private static void showConstructor(Constructor constructor) {
        System.out.println("Constructor: ");
        showModifiers(constructor);
        showParameters(constructor);
        showElementAnnotations(constructor);
    }

    private static void showModifiers(Member member) {
        int modifiers = member.getModifiers();

        System.out.print("\tmodifiers:");

        if(Modifier.isFinal(modifiers)) {
            System.out.println(" final");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.print(" abstract");
        }
        if (Modifier.isStatic(modifiers)) {
            System.out.print(" static");
        }
        if (Modifier.isPrivate(modifiers)) {
            System.out.print(" private");
        }
        if (Modifier.isProtected(modifiers)) {
            System.out.print(" protected");
        }
        if (Modifier.isPublic(modifiers)) {
            System.out.print(" public");
        }

        System.out.println();
    }

    private static void showElementAnnotations(AnnotatedElement annotatedElement) {
        System.out.print("\tannotations:");
        showAnnotations(annotatedElement);
    }

    private static void showAnnotations(AnnotatedElement annotatedElement) {
        Annotation[] annotations = annotatedElement.getDeclaredAnnotations();

        for (Annotation annotation:
                annotations) {
            System.out.print(" " + annotation.annotationType().getSimpleName());
        }

        System.out.println();
    }

    private static void showReturnType(Method method) {
        System.out.println("\treturn type: " + method.getReturnType().getSimpleName());
    }

    private static void showParameters(Executable executable) {
        System.out.println("\tparameters:");

        Parameter[] parameters = executable.getParameters();

        for (Parameter parameter:
                parameters) {
            System.out.println();
            System.out.println("\t\ttype: " + parameter.getType().getSimpleName());
            System.out.println("\t\tis final: " + showIsParameterFinal(parameter));
            System.out.print("\t");
            showElementAnnotations(parameter);
        }
    }

    private static boolean showIsParameterFinal(Parameter parameter) {
        return Modifier.isFinal(parameter.getModifiers());
    }
}