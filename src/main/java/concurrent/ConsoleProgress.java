package concurrent;

public class ConsoleProgress implements Runnable {

    @Override
    public void run() {
        var pr = new String[]{"\\", "|", "/"};
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(500);
                for (String el : pr) {
                    System.out.print("\rLoading: " + el);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(5000);
        progress.interrupt();
    }
}
