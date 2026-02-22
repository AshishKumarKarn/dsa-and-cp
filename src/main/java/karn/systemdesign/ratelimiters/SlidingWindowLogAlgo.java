package karn.systemdesign.ratelimiters;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Log based sliding window algorithm is a rate-limiting algorithm that
 * uses a log of timestamps to track incoming requests.
 * It allows a certain number of requests within a specified time window.
 * When a new request arrives, the algorithm checks the log to see how many requests
 * have been made in the current time window and decides whether to allow or reject
 * the new request based on the count. Older timestamps that fall outside the time
 * window are removed from the log to maintain an accurate count of requests within the window.
 * This algorithm is more accurate than fixed window algorithms as it provides
 * a true sliding window, but it can be less efficient due to the need to maintain
 * and clean up the log of timestamps.
 */
public class SlidingWindowLogAlgo {
    static void main() {
        SlidingWindowLogAlgo slidingWindowLogAlgo = new SlidingWindowLogAlgo(5, 1000);
        for (int i = 0; i < 10; i++) {
            if (slidingWindowLogAlgo.allowRequest()) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " dropped");
            }
        }
    }

    private final int maxReq;
    private final long timeWindow;
    private final Queue<Long> requestTimestamps;

    public SlidingWindowLogAlgo(int maxReq, long timeWindow) {
        this.maxReq = maxReq;
        this.timeWindow = timeWindow;
        this.requestTimestamps = new LinkedList<>();
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        // Remove timestamps that are outside the current time window
        while (!requestTimestamps.isEmpty() && currentTime - requestTimestamps.peek() >= timeWindow) {
            requestTimestamps.poll();
        }
        if (requestTimestamps.size() < maxReq) {
            requestTimestamps.offer(currentTime);
            return true; // Request allowed
        } else {
            return false; // Request dropped
        }
    }

}
