package MatrixMath.Multiplication;

import Matrices.NumberMatrix;

/**
 * Strategy interface:
 * provides interchangeability for different matrix multiplication functions.
 * Attention: multiply(a, b) != multiply(b, a) [matrix multiplication is not symmetrical].
 */
public interface NumberMatrixMultiplicationStrategy {
    NumberMatrix multiply(NumberMatrix a, NumberMatrix b);
}
