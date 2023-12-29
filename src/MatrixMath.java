/**
 * Basic math functionality for number matrices.
 *
 * @param <C> Class of matrix. Has to be a child of the number class.
 */
public interface MatrixMath<C extends Number> {
    Matrix<C> add(C n);

    Matrix<C> add(Matrix<C> other);

    Matrix<C> scale(C s);

    Matrix<C> multiply(Matrix<C> other);

    Matrix<C> gauss();

    Matrix<C> det();
}
