public class DoubleMatrix extends NumberMatrix {
    public DoubleMatrix(int rows, int columns, Number defaultValue) {
        super(rows, columns, defaultValue);
    }

    public DoubleMatrix(NumberMatrix copy) {
        super(copy);
    }

}
