package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV1 {

    public static void main(String[] args) {
        log("main start");

        HelloRunnable r = new HelloRunnable();
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
        Thread t3 = new Thread(r);
        t3.start();

        log("main end");
    }

}
