import java.util.Arrays;

public class IntegerMatrix implements Matrix<Integer> {

    public static void main(String[] args){
        //test
        IntegerMatrix testMatrix = new IntegerMatrix(3,3);
        System.out.println(testMatrix.rows()+" "+testMatrix.columns());
        System.out.println(testMatrix);
    }

    private Integer[][] matrix;

    public IntegerMatrix(int rows, int columns){
        matrix = new Integer[rows][columns];
        init();
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

    //getter
    @Override
    public Integer[] getRow(int row) {
        return new Integer[0];
    }

    @Override
    public Integer[] getColumn(int column) {
        return new Integer[0];
    }

    @Override
    public Integer get(int row, int column) {
        return 0;
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
            out = out.concat("\n");
        }
        return out;
    }
}
