package сollection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();
    private int size;

    public T pop() {
        T value = linked.deleteFirst();
        return value;
    }
    public void push(T value) {
        linked.addFirst(value);
    }
}
