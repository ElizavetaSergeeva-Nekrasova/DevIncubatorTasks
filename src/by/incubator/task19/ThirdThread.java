package by.incubator.task19;

import java.util.concurrent.Callable;

public class ThirdThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("ThirdThread starts");
        System.out.println("ThirdThread finishes");
        return null;
    }
}