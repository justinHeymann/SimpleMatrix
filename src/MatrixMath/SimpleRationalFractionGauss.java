package MatrixMath;

import Matrices.RationalFractionMatrix;
import Matrices.NumberMatrix;
import Exception.IllegalMatrixException;
import MatrixMath.StepByStepSolution.CalculationStep;
import MatrixMath.StepByStepSolution.ComprehensibleSolution;
import MatrixMath.StepByStepSolution.StepByStepSolution;
import Util.RationalFraction;

import java.util.ArrayList;

public class SimpleRationalFractionGauss implements ComprehensibleSolution {
    private RationalFractionMatrix currentMatrix;
    private StepByStepSolution solution;
    
    public RationalFractionMatrix gauss(RationalFractionMatrix input) {
        //init
        currentMatrix = new RationalFractionMatrix(input);
        solution = new StepByStepSolution();

        //check edge case
        if (NumberMatrix.isZero(input)){
            throw new IllegalArgumentException("Unable to use gaussian elimination on zero matrix");
        } else if (currentMatrix.columns() < 2 || currentMatrix.rows() < 2) {
            throw new IllegalArgumentException("Matrix is too small to use gaussian elimination");
        }


        optimizeRows();
        //System.out.println("swap rows: \n"+currentMatrix);
        solution.add("swap rows:", currentMatrix);

        int row = 0;
        int column = 0;

        while (row < currentMatrix.rows() && column < currentMatrix.columns()){
            RationalFraction entry = (RationalFraction) currentMatrix.get(row, column);
            if (!entry.isZero()){
                if (entry.compareTo(new RationalFraction(1, 1)) != 0){
                    rowDivision(row, entry);
                    //System.out.println("row division:\n"+currentMatrix);
                    solution.add("row division:", currentMatrix);
                }
                pivot(row, column);
                //System.out.println("pivot element "+row+", "+column+" :\n"+currentMatrix);
                solution.add("pivot element "+row+", "+column+" :", currentMatrix);

                optimizeRows();
                //System.out.println("swap rows:\n"+currentMatrix);

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
            RationalFraction fraction = (RationalFraction) n;
            if(fraction.isZero()){
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

    private void rowDivision(int rowIndex, RationalFraction divisor){
        try{
            Number[] row = currentMatrix.getRow(rowIndex);
            for (int i = 0; i < row.length; i++){
                RationalFraction fraction = (RationalFraction) row[i];
                row[i] = fraction.divide(divisor);
            }
            currentMatrix.setRow(rowIndex, row);
        }catch (IllegalMatrixException ex){
            System.out.println("An unexpected error occurred while dividing rows: "+ex);
        }
    }

    private void pivot(int row, int column){
        assert ((RationalFraction) currentMatrix.get(row, column)).compareTo(new RationalFraction(1,1)) == 0;
        for(int i = 0; i < currentMatrix.rows(); i++){
            RationalFraction entry = (RationalFraction) currentMatrix.get(i, column);
            if (!entry.isZero() && i != row){
                Number[] multiplied = multiplyRow(row, entry.multiply(-1));
                addRow(i, multiplied);
            }
        }
    }

    private Number[] multiplyRow(int rowIndex, RationalFraction multiplicity){
        Number[] row = currentMatrix.getRow(rowIndex);
        for (int i = 0; i < row.length; i++){
            RationalFraction entry = (RationalFraction) row[i];
            row[i] = entry.multiply(multiplicity);
        }
        return row;
    }
    private void addRow(int row, Number[] additional){
        Number[] target = currentMatrix.getRow(row);
        for(int i = 0; i < target.length; i++){
            RationalFraction a = (RationalFraction) target[i];
            RationalFraction b = (RationalFraction) additional[i];
            target[i] = a.add(b);
        }
        try {
            currentMatrix.setRow(row, target);
        }catch (IllegalMatrixException ignored){

        }
    }

    @Override
    public StepByStepSolution getSolution() {
        return solution;
    }
}
