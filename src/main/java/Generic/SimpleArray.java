package Generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int position = 0;

    public void add(T model) {
        this.array[position] = model;
        this.position++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, position);
        this.array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, position);
        System.arraycopy(array, (index + 1), array, index, (position - index));
        array[position - 1] = null;
        position--;
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int size = 0;

            @Override
            public boolean hasNext() {
                return position > size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[size++];
            }
        };
    }
}
