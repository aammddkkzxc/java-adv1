package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest());
        thread.start();

        sleep(100);
        log("thread 상태 " + thread.getState());

        LockSupport.unpark(thread);
//        thread.interrupt();
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("시작");
//            sleep(1000);
            LockSupport.park();
            log("thread 상태 " + Thread.currentThread().getState());
            log("interrupted " + Thread.currentThread().isInterrupted());
        }

    }

}
