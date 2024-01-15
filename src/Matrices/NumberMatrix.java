package Matrices;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;
import java.util.Objects;
import Exception.IllegalMatrixException;
import Util.RationalFraction;

import Iterator.Array2DIterator;

/**
 * Abstract Template for all number matrices
 * All indexes start at: 0
 */
public abstract class NumberMatrix implements Matrix<Number>, Iterable<Number>{
    private final Number[][] matrix;
    private final PropertyChangeSupport change = new PropertyChangeSupport(this);

    public NumberMatrix(int rows, int columns, Number defaultValue) {
        matrix = new Number[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                set(i, j, defaultValue);
            }
        }
    }

    /**
     * copy constructor
     * @param copy reference of copy
     */
    public NumberMatrix(NumberMatrix copy) {
        matrix = new Number[copy.rows()][copy.columns()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                set(i, j, copy.get(i, j));
            }
        }
    }

    //static
    public static boolean isZero(NumberMatrix input){
        String className = input.getType().getSimpleName();
        switch(className){
            case "Integer": {
                for(Number n: input){
                    Integer i = (Integer) n;
                    if(i != 0){
                        return false;
                    }
                }
                return true;
            }

            case "Double": {
                for(Number n: input){
                    Double d = (Double) n;
                    if(d != 0){
                        return false;
                    }
                }
                return true;
            }

            case "RationalFraction": {
                for(Number n: input){
                    RationalFraction fraction = (RationalFraction) n;
                    if(!fraction.isZero()){
                        return false;
                    }
                }
                return true;
            }

            default: throw new UnsupportedOperationException("Action not supported for given Matrix type: "+className);
        }
    }

    //manipulate
    public IntegerMatrix transpose() throws IllegalMatrixException {
        IntegerMatrix out = new IntegerMatrix(columns(), rows(), 0);
        for (int i = 0; i < columns(); i++) {
            out.setRow(i, getColumn(i));
        }
        return out;
    }

    //getter
    @Override
    public Number[] getRow(int row) {
        Number[] out = new Number[columns()];
        if (columns() >= 0) System.arraycopy(matrix[row], 0, out, 0, columns());
        return out;
    }

    @Override
    public Number[] getColumn(int column) {
        Number[] out = new Number[rows()];
        for (int i = 0; i < rows(); i++) {
            out[i] = matrix[i][column];
        }
        return out;
    }

    @Override
    public Number get(int row, int column) {
        return matrix[row][column];
    }

    @Override
    public int rows() {
        return matrix.length;
    }

    @Override
    public int columns() {
        return matrix[0].length;
    }

    @Override
    public int getSize() {
        return columns() * rows();
    }

    @Override
    public int getTrueSize() {
        int count = 0;
        for (Number i : this) {
            if (Objects.nonNull(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isQuadratic() {
        return rows() == columns();
    }

    //setter
    @Override
    public void set(int row, int column, Number input) {
        matrix[row][column] = input;
    }

    @Override
    public void setRow(int row, Number[] inputs) throws IllegalMatrixException {
        if (inputs.length != columns()) {
            throw new IllegalMatrixException(inputs.length + " does not match row length: " + columns(), this);
        }
        for (int i = 0; i < columns(); i++) {
            set(row, i, inputs[i]);
        }
    }

    @Override
    public void setColumn(int column, Number[] inputs) throws IllegalMatrixException {
        if (inputs.length != rows()) {
            throw new IllegalMatrixException(inputs.length + " does not match column length: " + rows(), this);
        }
        for (int i = 0; i < rows(); i++) {
            set(i, column, inputs[i]);
        }
    }

    //helper
    @Override
    public String toString() {
        String out = "";
        for (Number[] numbers : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                out = out.concat("|" + numbers[j]);
            }
            out = out.concat("|\n");
        }
        return out;
    }

    //iterable
    @Override
    public Iterator<Number> iterator() {
        return new Array2DIterator(matrix);
    }


    //beans
    public void addPropertyChangeListener(PropertyChangeListener listener){
        change.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        change.removePropertyChangeListener(listener);
    }

    @Override
    public Class<Number> getType() {
        return Number.class;
    }
}
