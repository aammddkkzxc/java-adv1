package thread.executor.future;

import thread.executor.CallableTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;

public class InvokeAllMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newFixedThreadPool(10);

        CallableTask t1 = new CallableTask("task1", 1000);
        CallableTask t2 = new CallableTask("task2", 2000);
        CallableTask t3 = new CallableTask("task3", 3000);

        List<CallableTask> tasks = List.of(t1, t2, t3);

        List<Future<Integer>> futures = es.invokeAll(tasks);

        for (Future<Integer> future : futures) {
            log("vlaue = " + future.get());
        }

        es.close();
    }

}
