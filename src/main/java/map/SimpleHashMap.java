package map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<K> {
    /**
     * Счечик елементов
     */
    private int size = 0;
    /**
     * Счечик модификаций
     */
    private int modCount = 0;
    /**
     * Изначальный размер таблицы
     */
    private int DEFAULT_CAPACITY = 1 << 4;
    /**
     * Максимальный размер таблицы
     */
    private int MAX_CAPACITY = 1 << 30;
    /**
     * Коэффициент загрузки таблицы
     */
    private float LOAD_FACTOR = 0.75f;
    /**
     * таблица
     */
    private Node<K, V>[] table;

    /**
     * Предельное количество элементов, при достижении которого размер хеш-таблицы увеличивается вдвое
     */
    private float threshold;

    public SimpleHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        threshold = table.length * LOAD_FACTOR;
    }

    public boolean insert(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            resizeTable();
        }
        boolean rsl = false;
        Node<K, V> node = new Node<>(key, value);
        node.hash = hash();
        int index = indexFor(key);
        if (table[index] == null) {
            table[index] = node;
            rsl = true;
            size++;
            modCount++;
        }
        return rsl;
    }

    public V get(K key) {
        if (key == null) {
            return table[0] == null ? null : table[0].value;
        }
        int index = indexFor(key);
        return table[index].value;
    }

    public boolean delete(K key) {
        int index = indexFor(key);
        size--;
        modCount--;
        return table[index].value == null;
    }
    public int size() {
        return this.size;
    }

    private static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private int indexFor(K key) {
        int h = key.hashCode();
        return h & (table.length - 1);
    }

    private int hash() {
        return hashCode() % table.length;
    }

    private void resizeTable() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                insert(node.key, node.value);
            }
        }
    }


    @Override
    public Iterator<K> iterator() {
        return new Iterator() {
            int position = 0;
            int modArr = modCount;

            @Override
            public boolean hasNext() {
                return size > position;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modArr != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[position];
            }
        };
    }

}
