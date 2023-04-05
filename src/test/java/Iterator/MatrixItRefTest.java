package Iterator;

import iterator.MatrixItRef;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class MatrixItRefTest {

    @Test
    void when4El() {
        int[][] in = {
                {1}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenHasNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenRowHasDiffSize() {
        int[][] in = {
                {1}, {2, 3}, {}, {}, {4}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.next()).isEqualTo(4);
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenFewEmpty() {
        int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenEmpty() {
        int[][] in = {
                {}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenEmptyThenNext() {
        int[][] in = {
                {}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThatThrownBy(it::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenMultiHasNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenNoElements() {
        int[][] in = {
                {}, {}, {}
        };
        MatrixItRef it = new MatrixItRef(in);
        assertThat(it.hasNext()).isFalse();
    }
}
