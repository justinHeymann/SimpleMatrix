package GUI;

import javax.swing.*;
import java.awt.*;

public class MatrixCreationPanel extends JPanel {
    public MatrixCreationPanel(){
        this.setLayout(new GridLayout(2,1));

        JPanel topFlow = new JPanel(new FlowLayout());
        JPanel bottomFlow = new JPanel(new FlowLayout());
        this.add(topFlow);
        this.add(bottomFlow);

        JLabel heightLabel = new JLabel("height:");
        JLabel widthLabel = new JLabel("width: ");
        JSpinner heightSpinner = new JSpinner();
        JSpinner widthSpinner = new JSpinner();

        JButton createButton = new JButton("create");
        createButton.addActionListener( a -> {
            bottomFlow.removeAll();
            bottomFlow.add(new MatrixInputPanel((Integer) heightSpinner.getAccessibleContext().getAccessibleValue().getCurrentAccessibleValue(), (Integer) widthSpinner.getAccessibleContext().getAccessibleValue().getCurrentAccessibleValue()));
            bottomFlow.revalidate();
        });

        topFlow.add(heightLabel);
        topFlow.add(heightSpinner);
        topFlow.add(widthLabel);
        topFlow.add(widthSpinner);
        topFlow.add(createButton);

        bottomFlow.add(new MatrixInputPanel(3,3));
        this.setVisible(true);

    }
}
