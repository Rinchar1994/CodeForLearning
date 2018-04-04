package main.java.Concurrence.concurrentPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Rinchar on 2018/4/4.
 */
public class MyExecutors extends Thread {
    private int index;

    public MyExecutors(int i) {
        this.index = i;
    }

    public void run() {
        try {
            System.out.println("[" + this.index + "] start....");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("[" + this.index + "] end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            service.execute(new MyExecutors(i));
            //service.submit(new MyExecutor(i));
        }
        service.shutdown();
        System.out.println("submit finish");
    }
}
