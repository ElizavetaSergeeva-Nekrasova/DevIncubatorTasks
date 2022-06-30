package by.incubator.task9;

public interface Starveble {
    default void isHungry() {
        System.out.println("not hungry");
    }
}
