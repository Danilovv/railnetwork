package util;

public final class Random {
    private static Random instance = new Random();

    private final java.util.Random random;

    private Random() {
        random = new java.util.Random();
    }

    public static int getDistance() {
        return instance.getRandom(9) + 1;
    }

    private int getRandom(final int bound) {
        return random.nextInt(bound);
    }
}
