package concurrent.thwait;

import javax.swing.plaf.TableHeaderUI;

public class MultiUser {
    public static void main(String[] args) throws InterruptedException {
        Barrier barrier = new Barrier();
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    barrier.on();
                },
                "master"
        );
        Thread slave = new Thread(
                () -> {
                    barrier.check();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "slave"
        );
        master.start();
        slave.start();
        master.join();
        slave.join();
    }
}
