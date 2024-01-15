package GUI;

import Matrices.DoubleMatrix;

import javax.swing.*;

public class GUI extends JFrame {
    public static void main(String[] args){
        new GUI();
    }
    public GUI(){
        super("Simple Matrix");
        this.setSize(1900, 600);

        DoubleMatrix matrix = new DoubleMatrix(3,3);
        this.add(new NumberMatrixPanel(matrix));

        this.setVisible(true);
    }
}
