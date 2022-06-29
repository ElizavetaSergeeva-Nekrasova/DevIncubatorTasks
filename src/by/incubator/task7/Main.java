package by.incubator.task7;

public class Main {
    public static void main(String[] args) {
        try {
            StackOverflowErrors.stackOverFlowMethod1();
        } catch(StackOverflowError error) {
            System.out.println("StackOverflow from stackOverFlowMethod1");
        }

        try {
            StackOverflowErrors.stackOverFlowMethod2();
        } catch(StackOverflowError error) {
            System.out.println("StackOverFlow from stackOverFlowMethod2");
        }

        try {
            OutOfMemoryErrors.outOfMemoryMethod1();
        } catch (OutOfMemoryError error) {
            System.out.println("OutOfMemory from outOfMemoryMethod1");
        }

        try {
            OutOfMemoryErrors.outOfMemoryMethod2();
        } catch (OutOfMemoryError error) {
            System.out.println("OutOfMemory from outOfMemoryMethod2");
        }
    }
}