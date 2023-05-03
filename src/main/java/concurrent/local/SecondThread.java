package concurrent.local;

public class SecondThread extends Thread {
    @Override
    public void run() {
        ThreadLocalDemo.tl.set("Это второй поток");
        System.out.println(ThreadLocalDemo.tl.get());
    }
}
