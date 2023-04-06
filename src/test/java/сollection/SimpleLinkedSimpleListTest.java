package сollection;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleLinkedSimpleListTest {

    @Test
    public void whenAddAndGet() {
        SimpleList<Integer> simpleList = new SimpleLinkedList<>();
        simpleList.add(1);
        simpleList.add(2);
        assertThat(simpleList.get(0), Is.is(1));
        assertThat(simpleList.get(1), Is.is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromOutOfBoundThenExceptionThrown() {
        SimpleList<Integer> simpleList = new SimpleLinkedList<>();
        simpleList.add(1);
        simpleList.add(2);
        simpleList.get(2);
    }

    @Test
    public void whenGetIteratorTwiceThenEveryFromBegin() {
        SimpleList<Integer> simpleList = new SimpleLinkedList<>();
        simpleList.add(1);
        simpleList.add(2);

        Iterator<Integer> first = simpleList.iterator();
        assertThat(first.hasNext(), Is.is(true));
        assertThat(first.next(), Is.is(1));
        assertThat(first.hasNext(), Is.is(true));
        assertThat(first.next(), Is.is(2));
        assertThat(first.hasNext(), Is.is(false));

        Iterator<Integer> second = simpleList.iterator();
        assertThat(second.hasNext(), Is.is(true));
        assertThat(second.next(), Is.is(1));
        assertThat(second.hasNext(), Is.is(true));
        assertThat(second.next(), Is.is(2));
        assertThat(second.hasNext(), Is.is(false));
    }
}