import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int position = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        position = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[position--];
    }
}
