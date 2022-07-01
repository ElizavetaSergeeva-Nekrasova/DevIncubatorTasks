package by.incubator.task7;

public class Main {
    public static void main(String[] args) {
        showResultOfStackOverFlowMethod1();
        showResultOfStackOverFlowMethod2();

        showResultOfOutOfMemoryMethod1();
        showResultOfOutOfMemoryMethod2();
    }

    private static void showResultOfStackOverFlowMethod1() {
        try {
            StackOverflowErrors.stackOverFlowMethod1();
        } catch(StackOverflowError error) {
            System.out.println("StackOverflow from stackOverFlowMethod1");
        }
    }

    private static void showResultOfStackOverFlowMethod2() {
        try {
            StackOverflowErrors.stackOverFlowMethod2();
        } catch(StackOverflowError error) {
            System.out.println("StackOverFlow from stackOverFlowMethod2");
        }
    }

    private static void showResultOfOutOfMemoryMethod1() {
        try {
            OutOfMemoryErrors.outOfMemoryMethod1();
        } catch (OutOfMemoryError error) {
            System.out.println("OutOfMemory from outOfMemoryMethod1");
        }
    }

    private static void showResultOfOutOfMemoryMethod2() {
        try {
            OutOfMemoryErrors.outOfMemoryMethod2();
        } catch (OutOfMemoryError error) {
            System.out.println("OutOfMemory from outOfMemoryMethod2");
        }
    }
}