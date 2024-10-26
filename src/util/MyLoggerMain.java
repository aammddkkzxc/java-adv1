package util;

import thread.start.HelloThread;

import static util.MyLogger.log;

public class MyLoggerMain {
    public static void main(String[] args) {
        log("hello thread");
        log(123);

    }
}