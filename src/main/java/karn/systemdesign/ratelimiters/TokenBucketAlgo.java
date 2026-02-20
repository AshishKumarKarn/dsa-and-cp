package karn.systemdesign.ratelimiters;

public class TokenBucketAlgo {
    static void main() {
        Bucket bucket = new Bucket(10, 5); // Capacity of 10 tokens, refill rate of 5 tokens per second

        // Simulate incoming requests
        for (int i = 0; i < 20; i++) {
            if (bucket.allowRequest()) {
                System.out.println("Request " + i + " allowed.");
            } else {
                System.out.println("Request " + i + " denied. 429 Too Many Requests.");
            }
            try {
                Thread.sleep(50); // Simulate time between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Bucket {
        int capacity;
        int tokens;
        long lastRefillTime;
        int refillRate;

        public Bucket(int capacity, int refillRate) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.tokens = capacity; // Start with a full bucket
            this.lastRefillTime = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            refillTokens();
            if (tokens > 0) {
                tokens--;
                return true; // Request allowed
            }
            return false; // Request denied
        }

        private void refillTokens() {
            long now = System.currentTimeMillis();
            long elapsedTime = now - lastRefillTime;
            int tokensToAdd = (int) (elapsedTime * refillRate / 1000);
            if (tokensToAdd > 0) {
                tokens = Math.min(capacity, tokens + tokensToAdd);
                lastRefillTime = now;
            }
        }
    }
}
