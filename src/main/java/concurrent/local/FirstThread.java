package concurrent.local;

public class FirstThread extends Thread {
    @Override
    public void run() {
        ThreadLocalDemo.tl.set("Это первый поток");
        System.out.println(ThreadLocalDemo.tl.get());
    }
}
