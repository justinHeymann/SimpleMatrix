package MatrixMath.Multiplication;

import Matrices.DoubleMatrix;
import Matrices.NumberMatrix;

public class SimpleDoubleMatrixMultiplicationStrategy implements NumberMatrixMultiplicationStrategy {

    @Override
    public NumberMatrix multiply(NumberMatrix a, NumberMatrix b) {
        DoubleMatrix out = new DoubleMatrix(a.rows(), b.columns());
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

    private double multiplyAndAdd(Number[] row, Number[] column) {
        double out = 0;
        assert (row.length == column.length);
        for (int i = 0; i < row.length; i++) {
            Double a = (Double) row[i];
            Double b = (Double) column[i];
            out += a * b;
        }
        return out;
    }
}
