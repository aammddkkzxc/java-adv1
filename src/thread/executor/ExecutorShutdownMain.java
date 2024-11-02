package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class ExecutorShutdownMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTask", 100_000)); // 100초 대기
        printState(es);
        log("== shutdown 시작 ==");
        shutdownAndAwaitTermination(es);
        log("== shutdown 완료 ==");
        printState(es);
    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {

        es.shutdown();

        try {
            log("서비스 정상 종료 시도");
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                log("일정 시간 내 정상 종료 실패 -> 강제 종료 시도");
                es.shutdownNow();

                if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                    log("강제 종료가 원할하게 안됨 -> 서비스가 종료되지 않았습니다.");
                }
            }
        } catch (InterruptedException e) {
            log("await 호출하여 대기중인 스레드 인터럽트 될 수 있음");
            es.shutdownNow();
        }

    }


}
