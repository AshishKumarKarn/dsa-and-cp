package karn.concepts.corejava.dsa;

import java.util.Random;

public class GFG {

    private static int testsRun = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        demo();

        System.out.println("\n=== Validation tests ===");
        testBasicQueries();
        testSingleElement();
        testFullRange();
        testEmptyRange();
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
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        SegmentTree sumTree = new SegmentTree(SegmentTree.Op.SUM);
        sumTree.build(a);
        System.out.println("SUM [1,3): " + sumTree.query(1, 3));

        SegmentTree minTree = new SegmentTree(SegmentTree.Op.MIN);
        minTree.build(a);
        System.out.println("MIN [2,6): " + minTree.query(2, 6));

        SegmentTree maxTree = new SegmentTree(SegmentTree.Op.MAX);
        maxTree.build(a);
        System.out.println("MAX [0,12): " + maxTree.query(0, 12));

        SegmentTree prodTree = new SegmentTree(SegmentTree.Op.PRODUCT);
        prodTree.build(a);
        System.out.println("PRODUCT [1,4): " + prodTree.query(1, 4));

        sumTree.updateTreeNode(2, 1);
        System.out.println("SUM [1,3) after update: " + sumTree.query(1, 3));
    }

    // ---------- individual checks ----------

    private static void testBasicQueries() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        check("SUM [1,3)", tree(SegmentTree.Op.SUM, a).query(1, 3), 2 + 3);
        check("SUM [0,12)", tree(SegmentTree.Op.SUM, a).query(0, 12), 78);
        check("MIN [2,6)", tree(SegmentTree.Op.MIN, a).query(2, 6), 3);
        check("MAX [0,12)", tree(SegmentTree.Op.MAX, a).query(0, 12), 12);
        check("PRODUCT [1,4)", tree(SegmentTree.Op.PRODUCT, a).query(1, 4), 2L * 3 * 4);
    }

    private static void testSingleElement() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        for (SegmentTree.Op op : SegmentTree.Op.values()) {
            SegmentTree t = tree(op, a);
            for (int i = 0; i < a.length; i++) {
                check(op + " single [" + i + "," + (i + 1) + ")", t.query(i, i + 1), a[i]);
            }
        }
    }

    private static void testFullRange() {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6};
        check("full SUM", tree(SegmentTree.Op.SUM, a).query(0, a.length), 31);
        check("full MIN", tree(SegmentTree.Op.MIN, a).query(0, a.length), 1);
        check("full MAX", tree(SegmentTree.Op.MAX, a).query(0, a.length), 9);
        check("full PRODUCT", tree(SegmentTree.Op.PRODUCT, a).query(0, a.length),
                3L * 1 * 4 * 1 * 5 * 9 * 2 * 6);
    }

    private static void testEmptyRange() {
        int[] a = {5, 6, 7, 8};
        // empty range [l, l) must return the operation's identity
        check("empty SUM", tree(SegmentTree.Op.SUM, a).query(2, 2), 0);
        check("empty MIN", tree(SegmentTree.Op.MIN, a).query(2, 2), Long.MAX_VALUE);
        check("empty MAX", tree(SegmentTree.Op.MAX, a).query(2, 2), Long.MIN_VALUE);
        check("empty PRODUCT", tree(SegmentTree.Op.PRODUCT, a).query(2, 2), 1);
    }

    private static void testUpdates() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree t = tree(SegmentTree.Op.SUM, a);
        check("SUM [0,8) before", t.query(0, 8), 36);

        t.updateTreeNode(0, 100);
        check("SUM [0,8) after a[0]=100", t.query(0, 8), 135);
        check("SUM [0,1) after a[0]=100", t.query(0, 1), 100);

        t.updateTreeNode(7, -8);
        check("SUM [0,8) after a[7]=-8", t.query(0, 8), 135 - 8 - 8);

        SegmentTree mn = tree(SegmentTree.Op.MIN, a);
        mn.updateTreeNode(3, -50);
        check("MIN [0,8) after a[3]=-50", mn.query(0, 8), -50);
        mn.updateTreeNode(3, 4); // restore
        check("MIN [0,8) restored", mn.query(0, 8), 1);

        SegmentTree mx = tree(SegmentTree.Op.MAX, a);
        mx.updateTreeNode(0, 999);
        check("MAX [0,8) after a[0]=999", mx.query(0, 8), 999);
    }

    private static void testNegativeAndZeroValues() {
        int[] a = {-3, 0, 5, -7, 2, 0};
        check("SUM with negatives/zero", tree(SegmentTree.Op.SUM, a).query(0, 6), -3);
        check("MIN with negatives/zero", tree(SegmentTree.Op.MIN, a).query(0, 6), -7);
        check("MAX with negatives/zero", tree(SegmentTree.Op.MAX, a).query(0, 6), 5);
        check("PRODUCT with a zero", tree(SegmentTree.Op.PRODUCT, a).query(0, 6), 0);
        check("PRODUCT excluding zero [0,1)", tree(SegmentTree.Op.PRODUCT, a).query(0, 1), -3);
        check("PRODUCT two negatives [0,1)+[3,4)", tree(SegmentTree.Op.PRODUCT, a).query(2, 5),
                5L * -7 * 2);
    }

    private static void testProductOverflowMatchesLong() {
        // Confirms PRODUCT uses long arithmetic; result is large but exact within long range.
        long[] a = {1_000_000L, 1_000_000L, 1_000L};
        SegmentTree t = new SegmentTree(SegmentTree.Op.PRODUCT);
        t.build(a);
        check("PRODUCT large within long", t.query(0, 3), 1_000_000_000_000_000L);
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
                    int r = l + rnd.nextInt(n - l + 1); // l..n, r exclusive (can equal l)
                    long expected = brute(op, arr, l, r);
                    long actual = t.query(l, r);
                    check("rand op=" + op + " n=" + n + " [" + l + "," + r + ")", actual, expected);
                }
            }
        }
    }

    private static long brute(SegmentTree.Op op, long[] arr, int l, int r) {
        long res = identity(op);
        for (int i = l; i < r; i++) res = combine(op, res, arr[i]);
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
