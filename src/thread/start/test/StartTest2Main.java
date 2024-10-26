package thread.start.test;

import static util.MyLogger.log;

public class StartTest2Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> log("hi"));
        thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    log("value: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread2 = new Thread(runnable, "counter");
        thread2.start();
    }

}
