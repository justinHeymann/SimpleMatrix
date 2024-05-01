package GUI;

import Matrices.NumberMatrix;

import javax.swing.*;
import java.awt.*;

public class NumberMatrixPanel extends JPanel {
    public NumberMatrixPanel(NumberMatrix matrix){
        this.setLayout(new BorderLayout());

        GridLayout gridLayout = new GridLayout(matrix.rows(), matrix.columns());

        JPanel gridPanel = new JPanel(gridLayout);

        this.add(gridPanel, BorderLayout.CENTER);

        for (int i = 0; i < matrix.rows(); i++){
            for (int j = 0; j < matrix.columns(); j++){
                JLabel temp = new JLabel(matrix.get(i, j).toString());
                temp.setAlignmentX(SwingConstants.CENTER);
                temp.setHorizontalAlignment(SwingConstants.CENTER);
                gridPanel.add(temp);
            }
        }

        //brackets
        Font brackets = new Font("Arial", Font.PLAIN, 25 * matrix.rows());
        JLabel leftBracket = new JLabel("(");
        leftBracket.setFont(brackets);
        JLabel rightBracket = new JLabel(")");
        rightBracket.setFont(brackets);

        this.add(leftBracket, BorderLayout.WEST);
        this.add(rightBracket, BorderLayout.EAST);

        this.setVisible(true);
    }
}
