package GUI;

import MatrixMath.StepByStepSolution.CalculationStep;
import MatrixMath.StepByStepSolution.StepByStepSolution;

import javax.swing.*;
import java.awt.*;


public class MatrixSolutionPanel extends JPanel {
    public MatrixSolutionPanel (StepByStepSolution solution){
        this.setLayout(new BorderLayout());
        JPanel boxPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);
        JScrollPane scrollPane = new JScrollPane(boxPanel);
        this.add(scrollPane, BorderLayout.CENTER);

        JLabel headerLabel = new JLabel("Found a step-by-step solution with "+solution.getStepCount()+" steps.");
        headerLabel.setAlignmentX(SwingConstants.LEFT);
        boxPanel.add(headerLabel);
        boxPanel.add(Box.createVerticalStrut(30));

        for (CalculationStep step: solution){
            boxPanel.add(new CalculationStepPanel(step));
            boxPanel.add(Box.createVerticalStrut(25));
        }

        boxPanel.add(new CalculationStepPanel(solution.getFinalResult()));

        this.setVisible(true);
    }
}
