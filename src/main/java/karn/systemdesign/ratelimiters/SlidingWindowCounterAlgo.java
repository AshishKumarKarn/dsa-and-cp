package karn.systemdesign.ratelimiters;

/**
 *
 * Sliding Window Counter Algorithm for Rate Limiting
 * This algorithm allows a certain number of requests within a sliding time window.
 * It maintains two counters: one for the current window and one for the previous window.
 * When a request arrives, it calculates the weighted count of requests in the current and previous windows to determine if the request should be allowed or throttled.
 * The window rotates as time progresses, allowing for a more accurate rate-limiting mechanism compared to fixed window algorithms.
 */

import java.util.concurrent.atomic.AtomicLong;

public class SlidingWindowCounterAlgo {
    static void main() {
        SlidingWindowCounterRateLimiter limiter = new SlidingWindowCounterRateLimiter(1000, 10); // 10 req/sec
        for (int i = 0; i < 50; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "THROTTLED"));
            try {
                Thread.sleep(80); // simulate traffic
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class SlidingWindowCounterRateLimiter {

        private final long windowSizeMs; // e.g., 1000 ms
        private final long limit;        // e.g., 100 requests per window

        // Window state
        private volatile long windowStartMs; // start time of current window
        private final AtomicLong currCount = new AtomicLong(0);
        private final AtomicLong prevCount = new AtomicLong(0);

        public SlidingWindowCounterRateLimiter(long windowSizeMs, long limit) {
            this.windowSizeMs = windowSizeMs;
            this.limit = limit;
            this.windowStartMs = System.currentTimeMillis();
        }

        /**
         * Try to acquire a permit for one request.
         *
         * @return true if allowed, false if rate-limited
         */
        public synchronized boolean tryAcquire() {
            long now = System.currentTimeMillis();
            rotateWindowsIfNeeded(now);

            long elapsedInCurrent = now - windowStartMs;
            double fractionIntoCurrent = Math.min(1.0, (double) elapsedInCurrent / windowSizeMs);
            double weightPrev = 1.0 - fractionIntoCurrent;

            double estimatedCount = currCount.get() + prevCount.get() * weightPrev;

            if (estimatedCount >= limit) {
                return false; // throttle
            }

            currCount.incrementAndGet();
            return true;
        }

        /**
         * Move windows if we've crossed into a new fixed window.
         * If we skipped more than one window, drop prevCount entirely.
         */
        private void rotateWindowsIfNeeded(long now) {
            long diff = now - windowStartMs;

            if (diff < windowSizeMs) {
                return; // still in the same window
            }

            // How many windows have we advanced?
            long windowsPassed = diff / windowSizeMs;

            if (windowsPassed == 1) {
                // Normal case: shift current to previous
                prevCount.set(currCount.get());
            } else {
                // We skipped at least one full window: previous no longer relevant
                prevCount.set(0);
            }

            currCount.set(0);

            // Align windowStartMs to the start of the current window
            windowStartMs = (windowStartMs + windowsPassed * windowSizeMs);
        }

        // --- Demo ---
        public static void main(String[] args) throws InterruptedException {
            SlidingWindowCounterRateLimiter limiter = new SlidingWindowCounterRateLimiter(1000, 10); // 10 req/sec

            for (int i = 0; i < 50; i++) {
                boolean allowed = limiter.tryAcquire();
                System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "THROTTLED"));
                Thread.sleep(80); // simulate traffic
            }
        }
    }
}