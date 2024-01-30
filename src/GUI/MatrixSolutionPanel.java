package GUI;

import MatrixMath.StepByStepSolution.CalculationStep;
import MatrixMath.StepByStepSolution.StepByStepSolution;

import javax.swing.*;
import java.awt.*;


public class MatrixSolutionPanel extends JPanel {
    public MatrixSolutionPanel (StepByStepSolution solution){
        this.setLayout(new BorderLayout());
        JPanel scrollableList = new JPanel();
        BoxLayout boxLayout = new BoxLayout(scrollableList, BoxLayout.Y_AXIS);
        scrollableList.setLayout(boxLayout);
        JScrollPane scrollPane = new JScrollPane(scrollableList);
        this.add(scrollPane, BorderLayout.CENTER);

        JLabel headerLabel = new JLabel("Step by Step Solution");
        headerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        scrollableList.add(headerLabel);
        for (CalculationStep step: solution){
            scrollableList.add(Box.createVerticalStrut(20));
            scrollableList.add(new CalculationStepPanel(step));
        }

        this.setVisible(true);
    }
}
