import java.util.Iterator;

public class Array2DIterator implements Iterator<Number> {
    private final Number[][] array;
    private int row = 0;
    private int column = 0;

    public Array2DIterator(Number[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            throw new IllegalArgumentException("Unable to create Iterator for empty matrix");
        }
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return row < array.length || column < array[0].length;
    }

    @Override
    public Number next() {
        Number out = array[row][column];
        if (!hasNext()) {
            throw new UnsupportedOperationException("Iterator has reached the end: no further elements");
        }
        if (row < array.length) {
            row++;
        } else {
            row = 0;
            column++;
        }
        return out;
    }
}
