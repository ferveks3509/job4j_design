package jdbc.map;

import map.SimpleHashMap;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void insert() {
        SimpleHashMap<Integer, String> first = new SimpleHashMap<>();
        first.insert(1, "one");
        Assert.assertThat(first.get(1), Is.is("one"));
    }

    @Test
    public void get() {
        SimpleHashMap<Integer, String> first = new SimpleHashMap<>();
        first.insert(1, "one");
        first.insert(2, "two");
        Assert.assertThat(first.get(2), Is.is("two"));
    }

    @Test
    public void delete() {
        SimpleHashMap<Integer, String> first = new SimpleHashMap<>();
        first.insert(1, "one");
        first.insert(2, "two");
        first.delete(1);
        Assert.assertThat(first.size(), Is.is(1));
    }
}