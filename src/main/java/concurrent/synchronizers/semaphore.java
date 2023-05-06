package concurrent.synchronizers;

import java.util.concurrent.Semaphore;

public class semaphore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("Thread execute task");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        Thread.sleep(500);
        semaphore.release(1);
    }
}
