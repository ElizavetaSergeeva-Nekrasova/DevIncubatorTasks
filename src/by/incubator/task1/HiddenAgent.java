package by.incubator.task1;

public class HiddenAgent {
    public static void main(String[] args) {

        Class <HiddenAgent> hiddenAgentClass = HiddenAgent.class;
        showInfoAboutClassLoaderAndHisParents(hiddenAgentClass);

        Class <Integer> integerClass = Integer.class;
        showInfoAboutClassLoader(integerClass);

        Class <MyClass> myClassClass = MyClass.class;
        showInfoAboutClassLoaderAndHisParents(myClassClass);
    }

    private static void showInfoAboutClassLoader (Class classObject) {
        ClassLoader classLoader = classObject.getClassLoader();
        System.out.println("Class loader of " + classObject + ": " +classLoader);
        System.out.println ("----------------------------------------------------");
    }

    private static void showInfoAboutClassLoaderAndHisParents (Class classObject) {
        ClassLoader classLoader = classObject.getClassLoader();
        System.out.println("Class loader of " + classObject + ": " +classLoader);
        System.out.println ("Its parent: " + classLoader.getParent());
        System.out.println ("Parent of its parent: " + classLoader.getParent().getParent());
        System.out.println ("----------------------------------------------------");
    }
 }
