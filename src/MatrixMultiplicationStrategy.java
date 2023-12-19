public interface MatrixMultiplicationStrategy<C extends Number> {
    IntegerMatrix multiply (IntegerMatrix a, IntegerMatrix b);
}
