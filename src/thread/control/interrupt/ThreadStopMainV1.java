package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();

        sleep(4000);
        task.flag = false;
    }

    static class MyTask implements Runnable {

        volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                log("시작");
                sleep(3000);
                log("자원 정리");
                log("종료");
            }
        }
    }
}
