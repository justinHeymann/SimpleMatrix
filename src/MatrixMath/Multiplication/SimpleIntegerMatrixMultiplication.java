package MatrixMath.Multiplication;

import Matrices.IntegerMatrix;
import Matrices.NumberMatrix;

public class SimpleIntegerMatrixMultiplication implements NumberMatrixMultiplicationStrategy {
    @Override
    public NumberMatrix multiply(NumberMatrix a, NumberMatrix b) {
        IntegerMatrix out = new IntegerMatrix(a.rows(), b.columns());
        if (a.columns() != b.rows()) {
            throw new IllegalArgumentException("Matrices can not be multiplied");
        }
        for (int i = 0; i < a.rows(); i++) {
            Number[] row = a.getRow(i);
            for (int j = 0; j < b.columns(); j++) {
                Number[] column = b.getColumn(j);
                out.set(i, j, multiplyAndAdd(row, column));
            }
        }

        return out;
    }

    private int multiplyAndAdd(Number[] row, Number[] column) {
        int out = 0;
        assert (row.length == column.length);
        for (int i = 0; i < row.length; i++) {
            Integer a = (Integer) row[i];
            Integer b = (Integer) column[i];
            out += a * b;
        }
        return out;
    }
}
