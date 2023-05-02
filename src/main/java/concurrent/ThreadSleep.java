package concurrent;

public class ThreadSleep {
    public static void main(String[] args) {
        Thread th = new Thread(
                () -> {
                    try {
                        System.out.println("Start loading...");
                        Thread.sleep(1000);
                        System.out.println("loaded");
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
        );
        th.start();
    }
}
