package concurrent.atomic;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Count {
    @GuardedBy("this")
    private int count;

    public synchronized void increment() {
        count++;
    }
    public synchronized   int get() {
        return count;
    }
}
