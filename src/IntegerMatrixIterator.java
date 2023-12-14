import java.util.Iterator;

public class IntegerMatrixIterator implements Iterator<Integer> {
    private final IntegerMatrix matrix;
    private int row = 0;
    private int column = 0;
    public IntegerMatrixIterator(IntegerMatrix matrix){
        this.matrix = matrix;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        Integer out = matrix.get(row, column);
        if (row < matrix.rows()){
            row++;
        }else if(column < matrix.columns()){
            row = 0;
            column++;
        }else {
            throw new UnsupportedOperationException("Iterator reached final element: no other element");
        }

        return out;
    }
}
