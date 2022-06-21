package by.incubator.task1;

public class HiddenAgent {
    public static void main(String[] args) {

        Class <HiddenAgent> hiddenAgentClass = HiddenAgent.class;
        ClassLoader hiddenAgentClassLoader = hiddenAgentClass.getClassLoader();
        System.out.println ("Class loader of HiddenAgent class: " + hiddenAgentClassLoader);
        System.out.println ("Its parent: " + hiddenAgentClassLoader.getParent());
        System.out.println ("Parent of its parent: " + hiddenAgentClassLoader.getParent().getParent());

        System.out.println ("---------------------------------------------------");

        Class <Integer> integerClass = Integer.class;
        ClassLoader integerClassLoader = integerClass.getClassLoader();
        System.out.println ("Class loader of Integer class: " + integerClassLoader);

        System.out.println ("---------------------------------------------------");

        Class <MyClass> myClassClass = MyClass.class;
        ClassLoader myClassClassLoader = myClassClass.getClassLoader();
        System.out.println ("Class loader of MyClass class: " + myClassClassLoader);
        System.out.println ("Its parent: " + myClassClassLoader.getParent());
        System.out.println ("Parent of its parent: " + myClassClassLoader.getParent().getParent());

    }
}
