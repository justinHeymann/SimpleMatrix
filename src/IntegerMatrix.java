import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Consumer;

public class IntegerMatrix implements Matrix<Integer>, Iterable<Integer>{

    private final Integer[][] matrix;

    public static void main(String[] args){
        //test
        IntegerMatrix testMatrix = new IntegerMatrix(3,3);
        System.out.println(testMatrix);
        System.out.println(Arrays.toString(testMatrix.getColumn(2)));
    }

    public IntegerMatrix(int rows, int columns){
        matrix = new Integer[rows][columns];
        initRandom();
    }

    //calc
    public void add(int i){

    }

    public void add(IntegerMatrix other){

    }

    public void scale(int i){

    }

    public void multiply(IntegerMatrix other){

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
                matrix[i][j] = rng.nextInt(100);
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
        return 0;
    }

    @Override
    public void set(int row, int column, Integer input) {
        matrix[row][column] = input;
    }

    //setter
    @Override
    public int getTrueSize() {
        return 0;
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

}
