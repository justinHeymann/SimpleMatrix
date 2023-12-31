package Matrices;

import MatrixMath.GaussStrategy;
import MatrixMath.Multiplication.NumberMatrixMultiplicationStrategy;
import MatrixMath.Multiplication.SimpleDoubleMatrixMultiplicationStrategy;

import java.util.Random;
import Exception.IllegalMatrixException;
import MatrixMath.SimpleDoubleGauss;

public class DoubleMatrix extends NumberMatrix {

    public static void main(String[] args) throws IllegalMatrixException {
        DoubleMatrix double1 = new DoubleMatrix(2,3);
        /*
        double1.setRow(0, new Number[]{1.0, 2.0, 3.0, 4.0, 5.0});
        double1.setRow(1, new Number[]{6.0, 7.0, 8.0, 9.0, 0.0});
        */

        System.out.println(double1);
        System.out.println(double1.gauss());
    }

    private final NumberMatrixMultiplicationStrategy multiplicationStrategy = new SimpleDoubleMatrixMultiplicationStrategy();
    private final GaussStrategy gaussStrategy = new SimpleDoubleGauss();
    public DoubleMatrix(int rows, int columns, Number defaultValue) {
        super(rows, columns, defaultValue);
    }
    public DoubleMatrix(int rows, int columns) {
        super(rows, columns, 0);
        initRandom();
    }

    public DoubleMatrix(NumberMatrix copy) {
        super(copy);
    }

    //private
    private void initRandom() {
        Random rng = new Random();
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                set(i, j, rng.nextInt(100) * 1.0);
            }
        }
    }

    //static
    public static DoubleMatrix unitMatrix(int length) throws IllegalMatrixException {
        if (length < 1) {
            throw new IllegalMatrixException("No Double matrix of length: " + length, null);
        }
        DoubleMatrix matrix = new DoubleMatrix(length, length, 0);
        for (int i = 0; i < length; i++) {
            matrix.set(i, i, 1);
        }
        return matrix;
    }

    public static boolean isZero(DoubleMatrix matrix) {
        for (Number n : matrix) {
            Double d = (Double) n;
            if (d != 0) {
                return false;
            }

        }
        return true;
    }

    //calc
    public DoubleMatrix add(Double n) {
        DoubleMatrix out = new DoubleMatrix(this);
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                Double Double = (Double) get(i, j);
                out.set(i, j, Double + n);
            }
        }
        return out;
    }

    public DoubleMatrix add(DoubleMatrix other) {
        DoubleMatrix out = new DoubleMatrix(this);
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                Double a = (Double) get(i, j);
                Double b = (Double) other.get(i, j);
                out.set(i, j, a + b);
            }
        }
        return out;
    }

    public DoubleMatrix scale(Double s) {
        DoubleMatrix out = new DoubleMatrix(this);
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                Double a = (Double) get(i, j);
                out.set(i, j, a * s);
            }
        }
        return out;
    }

    public DoubleMatrix multiply(DoubleMatrix other) {
        return (DoubleMatrix) multiplicationStrategy.multiply(this, other);
    }

    public DoubleMatrix gauss() {
        return gaussStrategy.gauss(this);
    }

    public DoubleMatrix det() {
        return null;
    }

    //getter
    public NumberMatrixMultiplicationStrategy getMultiplicationStrategy() {
        return multiplicationStrategy;
    }
}
