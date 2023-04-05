package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixItRef implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int cell;

    public MatrixItRef(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == cell) {
            cell = 0;
            row++;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][cell++];
    }
}
