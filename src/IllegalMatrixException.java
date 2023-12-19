public class IllegalMatrixException extends Exception{
    private Matrix matrix;
    public  IllegalMatrixException(String message, Matrix matrix){
        super(message);
        this.matrix = matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
