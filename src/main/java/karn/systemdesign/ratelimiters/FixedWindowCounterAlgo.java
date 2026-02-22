package karn.systemdesign.ratelimiters;

/**
 * Fixed Window Counter Algorithm for Rate Limiting
 * This algorithm allows a certain number of requests within a fixed time window.
 * Once the window expires, the counter resets and a new window starts.
 * This algorithm is simple to implement but can lead to burstiness at the edges of the windows,
 * where a large number of requests can be allowed at the end of one window and
 * the beginning of the next.
 * The allowRequest method checks if a request can be allowed based on the current count of requests and the time elapsed since the start of the current window.
 * If the window has expired, the counter is reset and a new window starts. If the request count exceeds the allowed limit within the window
 */
public class FixedWindowCounterAlgo {
    static void main() {
        FixedWindowCounterAlgo rateLimiter = new FixedWindowCounterAlgo(1000); // 1 second window
        for (int i = 0; i < 10; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request " + (i + 1) + " allowed");
            } else {
                System.out.println("Request " + (i + 1) + " denied");
            }
        }
    }

    private int windowSize;
    private int requestCount;
    private long windowStartTime;

    public FixedWindowCounterAlgo(int windowSize) {
        this.windowSize = windowSize;
        this.requestCount = 0;
        this.windowStartTime = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - windowStartTime >= windowSize) {
            // Reset the counter and start a new window
            requestCount = 0;
            windowStartTime = currentTime;
        }
        requestCount++;
        return requestCount <= 5; // Allow up to 5 requests per window
    }
}
