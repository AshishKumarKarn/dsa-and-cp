package karn.concepts.corejava.dsa;

import java.util.Random;

public class SegmentTreeDemo {

    private static int testsRun = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        demo();

        System.out.println("\n=== Validation tests ===");
        testBasicQueries();
        testSingleElement();
        testFullRange();
        testReversedRangeIsEmpty();
        testUpdates();
        testNegativeAndZeroValues();
        testProductOverflowMatchesLong();
        randomizedAgainstBruteForce();

        System.out.println("\n=== Summary ===");
        System.out.println("Tests run:    " + testsRun);
        System.out.println("Tests failed: " + testsFailed);
        if (testsFailed > 0) {
            throw new AssertionError(testsFailed + " test(s) FAILED");
        }
        System.out.println("ALL TESTS PASSED");
    }

    private static void demo() {
        // inclusive [l, r] semantics
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        SegmentTree sumTree = new SegmentTree(SegmentTree.Op.SUM);
        sumTree.build(a);
        System.out.println("SUM [1,3]: " + sumTree.query(1, 3));       // 2+3+4 = 9

        SegmentTree minTree = new SegmentTree(SegmentTree.Op.MIN);
        minTree.build(a);
        System.out.println("MIN [2,5]: " + minTree.query(2, 5));       // 3

        SegmentTree maxTree = new SegmentTree(SegmentTree.Op.MAX);
        maxTree.build(a);
        System.out.println("MAX [0,11]: " + maxTree.query(0, 11));     // 12

        SegmentTree prodTree = new SegmentTree(SegmentTree.Op.PRODUCT);
        prodTree.build(a);
        System.out.println("PRODUCT [1,3]: " + prodTree.query(1, 3));  // 2*3*4 = 24

        sumTree.updateTreeNode(2, 1);
        System.out.println("SUM [1,3] after a[2]=1: " + sumTree.query(1, 3)); // 2+1+4 = 7
    }

    // ---------- individual checks ----------

    private static void testBasicQueries() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        check("SUM [1,3]", tree(SegmentTree.Op.SUM, a).query(1, 3), 2 + 3 + 4);
        check("SUM [0,11]", tree(SegmentTree.Op.SUM, a).query(0, 11), 78);
        check("MIN [2,5]", tree(SegmentTree.Op.MIN, a).query(2, 5), 3);
        check("MAX [0,11]", tree(SegmentTree.Op.MAX, a).query(0, 11), 12);
        check("PRODUCT [1,3]", tree(SegmentTree.Op.PRODUCT, a).query(1, 3), 2L * 3 * 4);
    }

    // The key requirement: query(i, i) must return the single element arr[i] for every op.
    private static void testSingleElement() {
        int[] a = {-5, 2, 3, 4, 0, 6, 7, 8, 9, 10, 11, 12};
        for (SegmentTree.Op op : SegmentTree.Op.values()) {
            SegmentTree t = tree(op, a);
            for (int i = 0; i < a.length; i++) {
                // for MIN/MAX/SUM/PRODUCT a one-element range collapses to the element itself
                check(op + " single query(" + i + ", " + i + ")", t.query(i, i), a[i]);
            }
        }
    }

    private static void testFullRange() {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6};
        int last = a.length - 1;
        check("full SUM", tree(SegmentTree.Op.SUM, a).query(0, last), 31);
        check("full MIN", tree(SegmentTree.Op.MIN, a).query(0, last), 1);
        check("full MAX", tree(SegmentTree.Op.MAX, a).query(0, last), 9);
        check("full PRODUCT", tree(SegmentTree.Op.PRODUCT, a).query(0, last),
                3L * 1 * 4 * 1 * 5 * 9 * 2 * 6);
    }

    // With inclusive semantics, an empty range is expressed as l > r and yields identity.
    private static void testReversedRangeIsEmpty() {
        int[] a = {5, 6, 7, 8};
        check("empty SUM", tree(SegmentTree.Op.SUM, a).query(2, 1), 0);
        check("empty MIN", tree(SegmentTree.Op.MIN, a).query(2, 1), Long.MAX_VALUE);
        check("empty MAX", tree(SegmentTree.Op.MAX, a).query(2, 1), Long.MIN_VALUE);
        check("empty PRODUCT", tree(SegmentTree.Op.PRODUCT, a).query(2, 1), 1);
    }

    private static void testUpdates() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree t = tree(SegmentTree.Op.SUM, a);
        check("SUM [0,7] before", t.query(0, 7), 36);

        t.updateTreeNode(0, 100);
        check("SUM [0,7] after a[0]=100", t.query(0, 7), 135);
        check("SUM single query(0,0) after a[0]=100", t.query(0, 0), 100);

        t.updateTreeNode(7, -8);
        check("SUM [0,7] after a[7]=-8", t.query(0, 7), 135 - 8 - 8);

        SegmentTree mn = tree(SegmentTree.Op.MIN, a);
        mn.updateTreeNode(3, -50);
        check("MIN [0,7] after a[3]=-50", mn.query(0, 7), -50);
        check("MIN single query(3,3) after a[3]=-50", mn.query(3, 3), -50);
        mn.updateTreeNode(3, 4); // restore
        check("MIN [0,7] restored", mn.query(0, 7), 1);

        SegmentTree mx = tree(SegmentTree.Op.MAX, a);
        mx.updateTreeNode(0, 999);
        check("MAX [0,7] after a[0]=999", mx.query(0, 7), 999);
        check("MAX single query(0,0) after a[0]=999", mx.query(0, 0), 999);
    }

    private static void testNegativeAndZeroValues() {
        int[] a = {-3, 0, 5, -7, 2, 0};
        check("SUM with negatives/zero", tree(SegmentTree.Op.SUM, a).query(0, 5), -3);
        check("MIN with negatives/zero", tree(SegmentTree.Op.MIN, a).query(0, 5), -7);
        check("MAX with negatives/zero", tree(SegmentTree.Op.MAX, a).query(0, 5), 5);
        check("PRODUCT with a zero", tree(SegmentTree.Op.PRODUCT, a).query(0, 5), 0);
        check("PRODUCT single query(0,0)", tree(SegmentTree.Op.PRODUCT, a).query(0, 0), -3);
        check("PRODUCT [2,4] two negatives", tree(SegmentTree.Op.PRODUCT, a).query(2, 4),
                5L * -7 * 2);
    }

    private static void testProductOverflowMatchesLong() {
        // Confirms PRODUCT uses long arithmetic; result is large but exact within long range.
        long[] a = {1_000_000L, 1_000_000L, 1_000L};
        SegmentTree t = new SegmentTree(SegmentTree.Op.PRODUCT);
        t.build(a);
        check("PRODUCT large within long", t.query(0, 2), 1_000_000_000_000_000L);
    }

    // ---------- randomized brute-force validation ----------

    private static void randomizedAgainstBruteForce() {
        Random rnd = new Random(42);
        int rounds = 300;
        for (int round = 0; round < rounds; round++) {
            int n = 1 + rnd.nextInt(64);
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(41) - 20; // [-20, 20]

            SegmentTree.Op op = SegmentTree.Op.values()[rnd.nextInt(4)];
            SegmentTree t = new SegmentTree(op);
            t.build(arr);

            // mix of queries and updates
            for (int q = 0; q < 50; q++) {
                if (rnd.nextInt(4) == 0) {
                    int p = rnd.nextInt(n);
                    long v = rnd.nextInt(41) - 20;
                    arr[p] = v;
                    t.updateTreeNode(p, v);
                } else {
                    int l = rnd.nextInt(n);
                    int r = l + rnd.nextInt(n - l); // inclusive [l, r], r in [l, n-1]
                    long expected = brute(op, arr, l, r);
                    long actual = t.query(l, r);
                    check("rand op=" + op + " n=" + n + " [" + l + "," + r + "]", actual, expected);
                }
            }
        }
    }

    private static long brute(SegmentTree.Op op, long[] arr, int l, int r) {
        long res = identity(op);
        for (int i = l; i <= r; i++) res = combine(op, res, arr[i]); // inclusive
        return res;
    }

    private static long identity(SegmentTree.Op op) {
        switch (op) {
            case SUM: return 0L;
            case MIN: return Long.MAX_VALUE;
            case MAX: return Long.MIN_VALUE;
            case PRODUCT: return 1L;
            default: throw new IllegalStateException();
        }
    }

    private static long combine(SegmentTree.Op op, long a, long b) {
        switch (op) {
            case SUM: return a + b;
            case MIN: return Math.min(a, b);
            case MAX: return Math.max(a, b);
            case PRODUCT: return a * b;
            default: throw new IllegalStateException();
        }
    }

    // ---------- helpers ----------

    private static SegmentTree tree(SegmentTree.Op op, int[] a) {
        SegmentTree t = new SegmentTree(op);
        t.build(a);
        return t;
    }

    private static void check(String name, long actual, long expected) {
        testsRun++;
        if (actual != expected) {
            testsFailed++;
            System.out.println("FAIL: " + name + " expected=" + expected + " actual=" + actual);
        }
    }
}
