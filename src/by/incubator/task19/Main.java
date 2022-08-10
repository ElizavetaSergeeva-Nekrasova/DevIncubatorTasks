package by.incubator.task19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread();
        Thread secondThread = new Thread(new SecondThread());
        ThirdThread thirdThread = new ThirdThread();
        Thread fourthThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("FourthThread starts");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("FourthThread finishes");
            }
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        fourthThread.setDaemon(true);

        firstThread.start();
        secondThread.start();
        executorService.submit(thirdThread);
        fourthThread.start();

        executorService.shutdown();
    }
}