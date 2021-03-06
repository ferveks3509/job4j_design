package сollection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int size = 0;
    private int modArr = 0;

    public SimpleArray() {
        container = new Object[10];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size == container.length) {
            container = sizeArr();
        }
        this.container[size++] = model;
        modArr++;
    }

    private Object[] sizeArr() {
        Object[] newArr = new Object[size * 2];
        System.arraycopy(container, 0, newArr, 0, size * 2);
        return newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int failFast = modArr;
            int position = 0;

            @Override
            public boolean hasNext() {
                return size > position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modArr != failFast) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[position++];
            }
        };
    }
}
