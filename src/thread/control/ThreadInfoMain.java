package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log(mainThread);
        log(mainThread.threadId());
        log(mainThread.getName());
        log(mainThread.getState());
        log(mainThread.getPriority());
        log(mainThread.getThreadGroup());

        Thread thread = new Thread(new HelloRunnable(), "myThread");
//        thread.start();

        log(thread);
        log(thread.threadId());
        log(thread.getName());
        log(thread.getState());
        log(thread.getPriority());
        log(thread.getThreadGroup());

    }

}
