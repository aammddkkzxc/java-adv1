package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("hi");
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(() -> log("hi"));
        thread2.start();
    }

}
