public class SimpleMatrixMultiplication implements MatrixMultiplicationStrategy<Integer>{
    @Override
    public IntegerMatrix multiply(IntegerMatrix a, IntegerMatrix b) {
        IntegerMatrix out = new IntegerMatrix(a.rows(), b.columns());
        if (a.columns() != b.rows()) {
            throw new IllegalArgumentException("Matrices can not be multiplied");
        }
        for (int i = 0; i < a.rows(); i++){
            Integer[] row = a.getRow(i);
            for (int j = 0; j < b.columns(); j++){
                Integer[] column = b.getColumn(j);
                out.set(i, j, multiplyAndAdd(row, column));
            }
        }

        return out;
    }

    private int multiplyAndAdd(Integer[] row, Integer[] column){
        int out = 0;
        assert (row.length == column.length);
        for (int i = 0; i < row.length; i++){
            out += row[i] * column[i];
        }
        return out;
    }
}
