package karn.concepts.corejava.dsa;

/**
 * Segment tree that supports different range operations: SUM, MIN, MAX, PRODUCT.
 * Uses an iterative segment tree with dynamic size (tree array length = 2 * n).
 * Range queries use [l, r) semantics (r exclusive), indices are 0-based.
 */
public class SegmentTree {
    public enum Op { SUM, MIN, MAX, PRODUCT }

    private int n;
    private long[] tree;
    private final Op op;

    public SegmentTree(Op op) {
        this.op = op;
    }

    // build from int[] (convenience)
    public void build(int[] arr) {
        long[] a = new long[arr.length];
        for (int i = 0; i < arr.length; i++) a[i] = arr[i];
        build(a);
    }

    // build from long[]
    public void build(long[] arr) {
        this.n = arr.length;
        tree = new long[2 * n];

        // insert leaves
        for (int i = 0; i < n; i++) tree[n + i] = arr[i];

        // fill internal nodes
        for (int i = n - 1; i > 0; --i) tree[i] = combine(tree[i << 1], tree[i << 1 | 1]);
    }

    // point update: set position p (0-based) to value
    public void updateTreeNode(int p, long value) {
        int idx = p + n;
        tree[idx] = value;
        // Combine siblings in left-to-right order so this stays correct even for
        // non-commutative ops: left child is the even index, right child the odd one.
        for (int i = idx; i > 1; i >>= 1) tree[i >> 1] = combine(tree[i & ~1], tree[i | 1]);
    }

    // range query on [l, r) (0-based, r exclusive)
    public long query(int l, int r) {
        long resLeft = identity();
        long resRight = identity();

        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) resLeft = combine(resLeft, tree[l++]);
            if ((r & 1) == 1) resRight = combine(tree[--r], resRight);
        }

        return combine(resLeft, resRight);
    }

    private long identity() {
        switch (op) {
            case SUM: return 0L;
            case MIN: return Long.MAX_VALUE;
            case MAX: return Long.MIN_VALUE;
            case PRODUCT: return 1L;
            default: return 0L;
        }
    }

    private long combine(long a, long b) {
        switch (op) {
            case SUM: return a + b;
            case MIN: return Math.min(a, b);
            case MAX: return Math.max(a, b);
            case PRODUCT: return a * b;
            default: return 0L;
        }
    }
}

