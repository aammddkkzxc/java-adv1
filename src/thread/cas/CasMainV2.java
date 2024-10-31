package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());
        // incrementAndGet 구현
        int resultValue1 = incrementAndGet(atomicInteger);
        System.out.println("resultValue1 = " + resultValue1); int resultValue2 = incrementAndGet(atomicInteger);
        System.out.println("resultValue2 = " + resultValue2);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {

        int value;
        boolean result;

        do {
            value = atomicInteger.get();
            log("getValue: " + value);
            result = atomicInteger.compareAndSet(value, value + 1);
            log("result: " + result);
        } while (!result);

        return value + 1;
    }

}
