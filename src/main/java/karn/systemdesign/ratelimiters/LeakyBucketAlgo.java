package karn.systemdesign.ratelimiters;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Leaky Bucket Algorithm is a rate-limiting algorithm that controls the rate of requests by allowing them to "leak" out at a constant rate.
 * It uses a bucket to hold incoming requests, and if the bucket is full, new requests are dropped.
 * The bucket leaks at a fixed rate, allowing requests to be processed over time.
 * Implemented using a "Queue" to manage incoming requests and a timer to control the leaking process.
 * The allowRequest method checks if a request can be allowed based on the current size of the bucket and the leaking rate.
 */
public class LeakyBucketAlgo {
    static void main() {
        LeakyBucketAlgo leakyBucketAlgo = new LeakyBucketAlgo(5, 2);
        for (int i = 0; i < 10; i++) {
            if (leakyBucketAlgo.allowRequest()) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " dropped");
            }
        }
    }
    private final int capacity;
    private final int rate;
    private final Queue<Long> queue;

    public LeakyBucketAlgo(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.queue = new LinkedBlockingQueue<>();
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        // Remove requests that have been processed
        while (!queue.isEmpty() && currentTime - queue.peek() >= 1000 / rate) {
            queue.poll();
        }
        if (queue.size() < capacity) {
            queue.offer(currentTime);
            return true; // Request allowed
        } else {
            return false; // Request dropped
        }
    }
}