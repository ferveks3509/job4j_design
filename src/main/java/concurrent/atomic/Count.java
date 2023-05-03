package concurrent.atomic;

public class Count {
    private int count;

    public synchronized void increment() {
        count++;
    }
    public int get() {
        return count;
    }
}
