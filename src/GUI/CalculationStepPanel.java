package GUI;

import MatrixMath.StepByStepSolution.CalculationStep;

import javax.swing.*;
import java.awt.*;

public class CalculationStepPanel extends JPanel {
    public CalculationStepPanel(CalculationStep step){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        this.add(new JLabel(step.getIndex()+":"), BorderLayout.WEST);
        this.add(Box.createHorizontalStrut(20));
        this.add(wrapperPanel);

        wrapperPanel.add(new NumberMatrixPanel(step.getInterimSolution()), BorderLayout.CENTER);
        wrapperPanel.add(new JLabel(step.getExplanation()), BorderLayout.NORTH);


        this.setVisible(true);
    }

}
