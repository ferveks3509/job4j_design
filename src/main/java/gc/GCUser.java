package gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class GCUser {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        User u1 = new User("123", 123);
        User u2 = new User();
        //System.out.println(sizeOf(u1)); //72
        //System.out.println(sizeOf(u2)); //24
        info();
        for (int i = 0; i <= 10000; i++) {
            new User("N" + i, i);
        }
    }
}
