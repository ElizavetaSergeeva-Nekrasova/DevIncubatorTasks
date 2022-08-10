package by.incubator.task19;

public class FirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("FirstThread starts");
        System.out.println("FirstThread finishes");
    }
}