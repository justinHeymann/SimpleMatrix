package GUI;

import Matrices.RationalFractionMatrix;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MatrixCalculationPanel extends JPanel implements ChangeListener {
    private MatrixInputPanel inputPanel = new MatrixInputPanel(3, 3);
    private final JPanel bottomPanel = new JPanel(new FlowLayout());
    private final SpinnerNumberModel heightModel = new SpinnerNumberModel(3, 2, 10, 1);
    private final SpinnerNumberModel widthModel = new SpinnerNumberModel(3, 2, 10, 1);

    public MatrixCalculationPanel(){
        this.setLayout(new BorderLayout());
        JPanel boxPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);
        this.add(boxPanel, BorderLayout.NORTH);

        JPanel topPanel = new JPanel();
        boxPanel.add(topPanel);
        boxPanel.add(Box.createVerticalStrut(20));
        boxPanel.add(bottomPanel);
        JPanel solutionPanel = new JPanel();
        boxPanel.add(Box.createVerticalStrut(20));

        JLabel heightLabel = new JLabel("height:");
        JLabel widthLabel = new JLabel("width: ");

        JSpinner heightSpinner = new JSpinner(heightModel);
        JSpinner widthSpinner = new JSpinner(widthModel);

        heightSpinner.addChangeListener(this);
        widthSpinner.addChangeListener(this);

        JButton gaussButton = new JButton("gauss elimination");

        gaussButton.addActionListener( a -> {
            RationalFractionMatrix fractionMatrix = new RationalFractionMatrix(inputPanel.getMatrixFromInput());
            fractionMatrix.gauss();
            solutionPanel.removeAll();
            solutionPanel.add(new MatrixSolutionPanel(fractionMatrix.getSolution()));
            this.revalidate();
            this.repaint();

        });
        gaussButton.setToolTipText("This algorithm might not show you the simplest solution");

        JScrollPane scrollPane = new JScrollPane(solutionPanel);
        this.add(scrollPane, BorderLayout.CENTER);

        topPanel.add(heightLabel);
        topPanel.add(heightSpinner);
        topPanel.add(widthLabel);
        topPanel.add(widthSpinner);
        topPanel.add(gaussButton);

        bottomPanel.add(inputPanel);
        this.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        bottomPanel.removeAll();
        inputPanel = new MatrixInputPanel((Integer) heightModel.getValue(), (Integer) widthModel.getValue());
        bottomPanel.add(inputPanel);
        bottomPanel.revalidate();
        this.repaint();
    }
}
