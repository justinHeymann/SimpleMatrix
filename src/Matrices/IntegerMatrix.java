package Matrices;

import MatrixMath.Multiplication.NumberMatrixMultiplicationStrategy;
import MatrixMath.Multiplication.SimpleIntegerMatrixMultiplication;
import Exception.IllegalMatrixException;

import java.util.Arrays;
import java.util.Random;

public class IntegerMatrix extends NumberMatrix {

    private NumberMatrixMultiplicationStrategy multiplicationStrategy = new SimpleIntegerMatrixMultiplication();

    public IntegerMatrix(int rows, int columns, Integer defaultValue) {
        super(rows, columns, defaultValue);
    }

    public IntegerMatrix(int rows, int columns) {
        super(rows, columns, 0);
        initRandom();
    }

    public IntegerMatrix(int length) {
        this(length, length);
    }

    public IntegerMatrix(IntegerMatrix input) {
        super(input);
        multiplicationStrategy = input.getMultiplicationStrategy();
    }

    public static void main(String[] args) throws IllegalMatrixException {
        //test
        IntegerMatrix testMatrix1 = new IntegerMatrix(3, 7);
        System.out.println(testMatrix1 + " columns: " + testMatrix1.columns() + " rows: " + testMatrix1.rows());
        System.out.println(Arrays.toString(testMatrix1.getColumn(1)) + " " + Arrays.toString(testMatrix1.getRow(1)));
        testMatrix1.setRow(1, new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(testMatrix1);
        System.out.println(testMatrix1.multiply(new IntegerMatrix(7,3)));
    }

    //static
    public static IntegerMatrix unitMatrix(int length) throws IllegalMatrixException {
        if (length < 1) {
            throw new IllegalMatrixException("No integer matrix of length: " + length, null);
        }
        IntegerMatrix matrix = new IntegerMatrix(length, length, 0);
        for (int i = 0; i < length; i++) {
            matrix.set(i, i, 1);
        }
        return matrix;
    }

    //calc
    public IntegerMatrix add(Integer n) {
        IntegerMatrix out = new IntegerMatrix(this);
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                Integer integer = (Integer) get(i, j);
                out.set(i, j, integer + n);
            }
        }
        return out;
    }

    public IntegerMatrix add(IntegerMatrix other) {
        IntegerMatrix out = new IntegerMatrix(this);
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                Integer a = (Integer) get(i, j);
                Integer b = (Integer) other.get(i, j);
                out.set(i, j, a + b);
            }
        }
        return out;
    }

    public IntegerMatrix scale(Integer s) {
        IntegerMatrix out = new IntegerMatrix(this);
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                Integer a = (Integer) get(i, j);
                out.set(i, j, a * s);
            }
        }
        return out;
    }

    public IntegerMatrix multiply(IntegerMatrix other) {
        return (IntegerMatrix) multiplicationStrategy.multiply(this, other);
    }

    public IntegerMatrix det() {
        return null;
    }

    //private
    private void initRandom() {
        Random rng = new Random();
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                set(i, j, rng.nextInt(10));
            }
        }
    }

    //getter
    public NumberMatrixMultiplicationStrategy getMultiplicationStrategy() {
        return multiplicationStrategy;
    }

    @Override
    public Class getType(){
        return Integer.class;
    }
}
