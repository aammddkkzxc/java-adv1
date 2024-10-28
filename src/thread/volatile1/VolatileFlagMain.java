package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
        log("runFlag = " + task.flag);

        sleep(1000);
        task.flag = false;
        log("runFlag = " + task.flag);

    }

    static class MyTask implements Runnable {

        boolean flag = true;

        @Override
        public void run() {
            log("task start");
            while (flag) {

            }
            log("task end");
        }
    }
}
