package by.incubator.task9;

public interface Moveable {
    default void move() {
        System.out.println("movement");
    }
}
