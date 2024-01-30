package GUI;

import Matrices.NumberMatrix;

import javax.swing.*;
import java.awt.*;

public class NumberMatrixPanel extends JPanel {
    public NumberMatrixPanel(NumberMatrix matrix){

        GridLayout gridLayout = new GridLayout(matrix.rows(), matrix.columns());
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        this.setLayout(gridLayout);

        for (int i = 0; i < matrix.rows(); i++){
            for (int j = 0; j < matrix.columns(); j++){
                JLabel temp = new JLabel(matrix.get(i, j).toString());
                this.add(temp);
            }
        }

        this.setVisible(true);
    }
}
