package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MatrixCreationPanel extends JPanel implements ChangeListener {
    private MatrixInputPanel inputPanel = new MatrixInputPanel(3, 3);
    private final JPanel bottomFlow = new JPanel(new FlowLayout());
    private final SpinnerNumberModel heightModel = new SpinnerNumberModel(3, 2, 10, 1);
    private final SpinnerNumberModel widthModel = new SpinnerNumberModel(3, 2, 10, 1);

    public MatrixCreationPanel(){
        this.setLayout(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(2,1));
        this.add(gridPanel, BorderLayout.NORTH);

        JPanel topFlow = new JPanel(new FlowLayout());

        gridPanel.add(topFlow);
        gridPanel.add(bottomFlow);

        JLabel heightLabel = new JLabel("height:");
        JLabel widthLabel = new JLabel("width: ");

        JSpinner heightSpinner = new JSpinner(heightModel);
        JSpinner widthSpinner = new JSpinner(widthModel);

        heightSpinner.addChangeListener(this);
        widthSpinner.addChangeListener(this);

        JButton createButton = new JButton("gauss");
        createButton.addActionListener( a -> {
            System.out.println(inputPanel.getMatrixFromInput());
        });

        topFlow.add(heightLabel);
        topFlow.add(heightSpinner);
        topFlow.add(widthLabel);
        topFlow.add(widthSpinner);
        topFlow.add(createButton);

        bottomFlow.add(inputPanel);
        this.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        bottomFlow.removeAll();
        inputPanel = new MatrixInputPanel((Integer) heightModel.getValue(), (Integer) widthModel.getValue());
        bottomFlow.add(inputPanel);
        bottomFlow.revalidate();
        this.repaint();
    }
}
