package GUI;

import Matrices.NumberMatrix;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NumberMatrixPanel extends JPanel implements PropertyChangeListener {
    public NumberMatrixPanel(NumberMatrix matrix){
        matrix.addPropertyChangeListener(this);
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());

        //GridBagLayout

        GridBagLayout gridLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        gridLayout.setConstraints(this, constraints);
        JPanel gridPanel = new JPanel(gridLayout);
        this.add(gridPanel, BorderLayout.CENTER);


        //init
        for(int i = 0; i < matrix.rows(); i++){
            constraints.gridy = i;
            for (int j = 0; j < matrix.columns(); j++){
                constraints.gridx = j;
                JLabel temp = new JLabel(String.valueOf(matrix.get(i,j)));
                temp.setPreferredSize(new Dimension(100, 100));
                this.add(temp);
            }
        }

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
