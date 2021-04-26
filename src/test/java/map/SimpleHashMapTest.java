package map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void insert() {
        SimpleHashMap<Integer, String> first = new SimpleHashMap<>();
        first.insert(1, "one");
        assertThat(first.get(1), is("one"));
    }
    @Test
    public void get() {
        SimpleHashMap<Integer, String> first = new SimpleHashMap<>();
        first.insert(1, "one");
        first.insert(2, "two");
        assertThat(first.get(2), is("two"));
    }

    @Test
    public void delete() {
        SimpleHashMap<Integer, String> first = new SimpleHashMap<>();
        first.insert(1, "one");
        first.insert(2, "two");
        first.delete(1);
        assertThat(first.size(), is(1));
    }
}