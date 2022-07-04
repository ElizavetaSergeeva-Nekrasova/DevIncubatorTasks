package by.incubator.task9;

public interface Voiceable {
    default void voice() {
        System.out.println("voice");
    }
}
