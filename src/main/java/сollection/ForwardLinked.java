package сollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        size++;
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }
    public void addFirst(T value) {
        Node<T> node = new Node<>(value, head);
        head = node;
    }

    public T deleteFirst() {
        size--;
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }
    public T deleteLast() {
        size--;
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            T rsl = head.value;
            head = null;
            return rsl;
        }
        Node<T> last = head;
        Node<T> el = head;
        while (last.next != null) {
            el = last;
            last = head.next;
        }
        el.next = null;
        return last.value;
    }
    public void revert() {
        if (head == null || head.next == null) {
            return;
        }
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> forward = null;
        while (current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        this.head = previous;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}

