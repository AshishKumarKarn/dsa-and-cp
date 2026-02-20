package karn.platforms;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Solution {
    static void main() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
            }
//            cyclicBarrier.
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 9; i < 15; i++) {
                System.out.println("Thread 2: " + i);
            }
        });
        t1.start();
        latch.await();
        t2.start();
    }
}
