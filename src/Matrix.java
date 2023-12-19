/**
 * Provides basic function for all matrix structures
 * Not all functions might be available or overlap for a given implementation of Matrix
 * @param <C> placeholder for entries of matrix
 */
 interface Matrix<C> {

    //getter
     C[] getRow(int row);
     C[] getColumn(int column);
     C get(int row, int column);
     int rows();
     int columns();

     int getSize();

    /**
     * may be different to getSize()
     * @return number of elements in matrix that are different from null
     */
     int getTrueSize();

    //setter
     void set(int row, int column, C input);
     void setRow(int row, C[] inputs) throws IllegalMatrixException ;
     void setColumn(int column, C[] inputs) throws IllegalMatrixException ;

     //helper
    String toString();
    boolean equals(Object o);



}
