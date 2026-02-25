package karn.platforms;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Solution {
    static void main() throws InterruptedException {
        Object object1 = new Object();
        Thread thread1 = new Thread(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                synchronized (object1){
                    object1.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 20; i < 30; i++) {
                System.out.println(i);
            }
        });
        int[] arr = new int[2];
        Integer[] ar  = Arrays.stream(arr).mapToObj(a->a).toArray(Integer[]::new);
        int[] arr1 =
                Arrays.stream(ar).mapToInt(a->a).toArray();
        thread1.start();

        thread2.start();
        synchronized (object1) {
            object1.notify();
        }


    }
    private void method() {
        synchronized (this) {
            //api call -> 20 seconds
        }
    }
}
