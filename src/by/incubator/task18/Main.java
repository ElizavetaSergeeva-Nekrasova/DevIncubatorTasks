package by.incubator.task18;

public class Main {
    public static void main(String[] args) {
        Apple apple = ObjectFactory.create(Apple.class);

        Initializer.initialize(apple, "color", "green");
        Initializer.initialize(apple, "weight", 1.4d);
        showApple(apple);

        BadInitializer.initialize(apple, "color", "red");
        BadInitializer.initialize(apple, "weight", 1.2d);
        showApple(apple);
    }

    private static void showApple(Apple apple) {
        System.out.println("Color: " + apple.getColor());
        System.out.println("Weight: " + apple.getWeight());
    }
}