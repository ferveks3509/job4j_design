package сollection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleList<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> head;

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Iterator<E> it = iterator();
        E el = null;
        for (int i = 0; i <= index; i++) {
            el = it.next();
        }
        return el;
    }

    public int size() {
        return size;
    }

    @Override
    public E set(int index, E newValue) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> el = head;
            private Node<E> nextEl;
            final int failFast = modCount;

            @Override
            public boolean hasNext() {
                checkEx();
                return el != null;
            }

            @Override
            public E next() {
                checkEx();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                nextEl = el;
                el = el.next;
                return nextEl.item;

            }

            private void checkEx() {
                if (failFast != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}