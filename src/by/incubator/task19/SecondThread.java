package by.incubator.task19;

public class SecondThread implements Runnable{
    @Override
    public void run() {
        System.out.println("SecondThread starts");
        System.out.println("SecondThread finishes");
    }
}