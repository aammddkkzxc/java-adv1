package thread.executor.future;

import java.util.concurrent.*;

public class SumTaskMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> submit1 = es.submit(new MyCallableSumTask(1, 50));
        Future<Integer> submit2 = es.submit(new MyCallableSumTask(51, 100));

        Integer one = submit1.get();
        Integer two = submit2.get();

        System.out.println(one + two);

        es.close();
    }

    private static class MyCallableSumTask implements Callable<Integer> {

        int startNum;
        int endNum;

        public MyCallableSumTask(int startNum, int endNum) {
            this.startNum = startNum;
            this.endNum = endNum;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;

            Thread.sleep(2000);

            for (int i = startNum; i <= endNum; i++) {
                sum += i;
            }

            return sum;
        }
    }

}
