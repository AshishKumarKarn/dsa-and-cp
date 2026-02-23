package karn.systemdesign.patterns;

public class HolderPattern {
    private HolderPattern() {
    }

    private static class Holder {
        private static final HolderPattern INSTANCE = new HolderPattern();
    }

    public static HolderPattern getInstance() {
        return Holder.INSTANCE;
    }

    static void main() {
        HolderPattern instance1 = HolderPattern.getInstance();
        HolderPattern instance2 = HolderPattern.getInstance();
        System.out.println(instance1 == instance2); // true
    }
}
