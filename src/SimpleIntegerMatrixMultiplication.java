public class SimpleIntegerMatrixMultiplication implements NumberMatrixMultiplicationStrategy {
    @Override
    public NumberMatrix multiply(NumberMatrix a, NumberMatrix b) {
        IntegerMatrix out = new IntegerMatrix(a.rows(), b.columns());
        if (a.columns() != b.rows()) {
            throw new IllegalArgumentException("Matrices can not be multiplied");
        }
        for (int i = 0; i < a.rows(); i++) {
            Integer[] row = (Integer[]) a.getRow(i);
            for (int j = 0; j < b.columns(); j++) {
                Integer[] column = (Integer[]) b.getColumn(j);
                out.set(i, j, multiplyAndAdd(row, column));
            }
        }

        return out;
    }

    private int multiplyAndAdd(Integer[] row, Integer[] column) {
        int out = 0;
        assert (row.length == column.length);
        for (int i = 0; i < row.length; i++) {
            out += row[i] * column[i];
        }
        return out;
    }
}
