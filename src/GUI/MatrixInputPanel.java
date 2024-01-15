package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MatrixInputPanel extends JPanel {
    private JTextField[] textFields;
    public MatrixInputPanel(int height, int width){
        this.setBorder(new LineBorder(Color.red, 3));
        GridLayout gridLayout = new GridLayout(height, width);
        gridLayout.setHgap(25);
        gridLayout.setVgap(25);
        this.setSize(100, 100);

        JPanel scrollGrid = new JPanel(gridLayout);
        JScrollPane scrollPane = new JScrollPane(scrollGrid);
        this.add(scrollPane);

        textFields = new JTextField[height * width];
        for (int i = 0; i < height * width; i++){
            JTextField temp = new JTextField(""+i,4);
            temp.setHorizontalAlignment(0);
            scrollGrid.add(temp);
            textFields[i] = temp;
        }


        this.setVisible(true);
    }

}
