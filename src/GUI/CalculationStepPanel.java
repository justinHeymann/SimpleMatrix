package GUI;

import MatrixMath.StepByStepSolution.CalculationStep;

import javax.swing.*;
import java.awt.*;

public class CalculationStepPanel extends JPanel {
    public CalculationStepPanel(CalculationStep step){
        this.setLayout(new BorderLayout());

        JLabel explanation = new JLabel(step.getExplanation());
        explanation.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(explanation, BorderLayout.NORTH);

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.X_AXIS));
        this.add(wrapperPanel, BorderLayout.CENTER);

        wrapperPanel.add(new JLabel(step.getIndex()+":"));
        wrapperPanel.add(Box.createHorizontalStrut(20));

        wrapperPanel.add(new NumberMatrixPanel(step.getInterimSolution()));


        this.setVisible(true);
    }

}
