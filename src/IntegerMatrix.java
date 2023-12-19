import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;

public class IntegerMatrix implements Matrix<Integer>, Iterable<Integer>{

    private final Integer[][] matrix;
    private MatrixMultiplicationStrategy<Integer> multiplicationStrategy = new SimpleMatrixMultiplication();

    public static void main(String[] args){
        //test
        IntegerMatrix testMatrix1 = new IntegerMatrix(3,3);
        IntegerMatrix testMatrix2 = new IntegerMatrix(3,3);
        System.out.println(testMatrix1+"\n"+testMatrix2);
        System.out.println(testMatrix1.multiply(testMatrix2));
    }

    public IntegerMatrix(int rows, int columns){
        matrix = new Integer[rows][columns];
        initRandom();

    }

    /**
     * copy constructor
     * @param input reference of copy
     */
    public IntegerMatrix(IntegerMatrix input){
        matrix = new Integer[input.rows()][input.columns()];
        multiplicationStrategy = input.getMultiplicationStrategy();
        for (int i = 0; i < rows(); i++){
            for (int j = 0; j < columns(); j++){
                set(i, j, input.get(i, j));
            }
        }
    }

    //calc
    public IntegerMatrix add(int n){
        IntegerMatrix out = new IntegerMatrix(this);
        for (int i = 0; i < rows(); i++){
            for (int j = 0; j < columns(); j++){
                out.set(i,j, get(i,j) + n);
            }
        }
        return out;
    }

    public IntegerMatrix add(IntegerMatrix other){
        IntegerMatrix out = new IntegerMatrix(this);
        for (int i = 0; i < rows(); i++){
            for (int j = 0; j < columns(); j++){
                out.set(i,j, get(i,j) + get(i,j));
            }
        }
        return out;
    }

    public IntegerMatrix scale(int s){
        IntegerMatrix out = new IntegerMatrix(this);
        for (int i = 0; i < rows(); i++){
            for (int j = 0; j < columns(); j++){
                out.set(i,j, get(i,j) * s);
            }
        }
        return out;
    }

    public IntegerMatrix multiply(IntegerMatrix other){
        return multiplicationStrategy.multiply(this, other);
    }

    public void gauss(){

    }

    public void det(){

    }

    //private
    private void init(){
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = null;
            }
        }
    }

    public void initRandom(){
        Random rng = new Random();
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = rng.nextInt(10);
            }
        }
    }

    //getter
    @Override
    public Integer[] getRow(int row) {
        return (matrix[row]);
    }

    @Override
    public Integer[] getColumn(int column) {
        Integer[] out = new Integer[columns()];
        for (int i = 0; i < columns(); i++){
            out[i] = matrix[i][column];
        }
        return out;
    }

    @Override
    public Integer get(int row, int column) {
        return matrix[row][column];
    }

    @Override
    public int rows() {
        return matrix.length;
    }

    @Override
    public int columns(){
        return matrix[0].length;
    }

    @Override
    public int getSize() {
        return columns() * rows();
    }

    @Override
    public int getTrueSize() {
        int count = 0;
        for (Integer i: this) {
            if (Objects.nonNull(i)){
                count++;
            }
        }
        return count;
    }

    public MatrixMultiplicationStrategy<Integer> getMultiplicationStrategy() {
        return multiplicationStrategy;
    }

    //setter
    @Override
    public void set(int row, int column, Integer input) {
        matrix[row][column] = input;
    }

    @Override
    public void setRow(int row, Integer[] inputs) {

    }

    @Override
    public void setColumn(int column, Integer[] inputs) {

    }

    //helper
    @Override
    public String toString(){
        String out = "";
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                out = out.concat("|"+matrix[i][j]);
            }
            out = out.concat("|\n");
        }
        return out;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Array2DIterator(matrix);
    }
}
