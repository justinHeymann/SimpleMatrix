package MatrixMath;

import Matrices.DoubleMatrix;
import Exception.IllegalMatrixException;

/**
 * A simple gaussian elimination algorithm
 * rounding error can occur
 */

public class SimpleDoubleGauss implements GaussStrategy {
    private DoubleMatrix currentMatrix;

    @Override
    public DoubleMatrix gauss(DoubleMatrix input) {
        //init
        currentMatrix = new DoubleMatrix(input);

        //check edge case
        if (DoubleMatrix.isZero(input)){
            throw new IllegalArgumentException("Unable to use gaussian elimination on zero matrix");
        } else if (currentMatrix.columns() < 2 || currentMatrix.rows() < 2) {
            throw new IllegalArgumentException("Matrix is too small to use gaussian elimination");
        }

        optimizeRows();

        int row = 0;
        int column = 0;

        while (row < currentMatrix.rows() && column < currentMatrix.columns()){
            Double entry = (Double) currentMatrix.get(row, column);
            if (entry != 0){
                if (entry != 1){
                    rowDivision(row, entry);
                }
                pivot(row, column);
                row++;
            }
            column++;
        }



        return currentMatrix;
    }

    private void optimizeRows(){
        for (int i = 0; i < currentMatrix.rows() -1 ; i++){
            int currentZeros = leadingZeros(currentMatrix.getRow(i));
            int nextZeros = leadingZeros(currentMatrix.getRow(i + 1));
            if (currentZeros > nextZeros){
                switchRows(i, i + 1);
                i = 0;
            }
        }
    }

    private int leadingZeros(Number[] row){
        int zeroCount = 0;
        for (Number n : row){
            if((Double) n == 0){
                zeroCount++;
            }else {
                break;
            }
        }
        return zeroCount;
    }

    private void switchRows(int rowA, int rowB) {
        try {
            Number[] tempRow = currentMatrix.getRow(rowA);
            currentMatrix.setRow(rowA, currentMatrix.getRow(rowB));
            currentMatrix.setRow(rowB, tempRow);
        }catch (IllegalMatrixException ex){
            System.err.println("An unexpected error occurred during gaussian elimination: "+ex);
        }
    }

    private void rowDivision(int rowIndex, Double divisor){
        try{
            Number[] row = currentMatrix.getRow(rowIndex);
            for (int i = 0; i < row.length; i++){
                row[i] = (Double) row[i] / divisor;
            }
            currentMatrix.setRow(rowIndex, row);
        }catch (IllegalMatrixException ex){
            System.out.println("An unexpected error occurred while dividing rows: "+ex);
        }
    }

    private void pivot(int row, int column){
        assert ((Double) currentMatrix.get(row, column) == 1);
        for(int i = 0; i < currentMatrix.rows(); i++){
            Double entry = (Double) currentMatrix.get(i, column);
            if (entry != 0 && i != row){
                Number[] multiplied = multiplyRow(row, entry * (-1));
                addRow(i, multiplied);
            }
        }
    }

    private Number[] multiplyRow(int rowIndex, Double multiplicity){
        Number[] row = currentMatrix.getRow(rowIndex);
        for (int i = 0; i < row.length; i++){
            row[i] = (Double) row[i] * multiplicity;
        }
        return row;
    }
    private void addRow(int row, Number[] additional){
        Number[] target = currentMatrix.getRow(row);
        for(int i = 0; i < target.length; i++){
            target[i] = (Double) target[i] + (Double) additional[i];
        }
        try {
            currentMatrix.setRow(row, target);
        }catch (IllegalMatrixException ignored){

        }
    }
}
