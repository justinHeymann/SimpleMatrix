package Exception;

import Matrices.Matrix;

public class IllegalMatrixException extends Exception {
    private final Matrix matrix;

    public IllegalMatrixException(String message, Matrix matrix) {
        super(message);
        this.matrix = matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
