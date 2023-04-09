package сollection.set;

import сollection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSetArr<T> implements SimpleSet<T> {
    private final SimpleArrayList<T> data = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean rsl = !contains(value);
        if (rsl)
            data.add(value);
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        for (T el : data) {
            if (Objects.equals(el, value))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
