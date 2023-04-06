package сollection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(Object value) {
        if (size == container.length) {
            increaseData();
        }
        container[size++] = (T) value;
        modCount++;
    }

    @Override
    public T set(int index, Object newValue) {
        Objects.checkIndex(index, container.length);
        if (size == container.length) {
            increaseData();
        }
        T oldValue = container[index];
        container[index] = (T) newValue;
        modCount++;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[--size] = null;
        modCount++;
        return oldValue;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int cursor = 0;
            final int checkModCount = modCount;

            @Override
            public boolean hasNext() {
                checkEx();
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                checkEx();
                return container[cursor++];
            }

            private void checkEx() {
                if (modCount != checkModCount)
                    throw new ConcurrentModificationException();
            }
        };
    }

    private T[] increaseData() {
        return container = Arrays.copyOf(container, container.length * 2 + 10);
    }
}
