package karn.interviews.testSigma.interviews.ivanti;

public class Solution {
    static void main() throws InterruptedException {
        final Object object = new Object();
        Runnable runnable1 = () -> {

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }

            synchronized (object){
                object.notify();
            }

        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 26; i++) {
                System.out.println((char) (i + 'a'));
            }
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        synchronized (object){
            object.wait();
        }
//        t1.
        t2.start();
    }
}
