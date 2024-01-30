package GUI;

import MatrixMath.StepByStepSolution.CalculationStep;

import javax.swing.*;
import java.awt.*;

public class CalculationStepPanel extends JPanel {
    public CalculationStepPanel(CalculationStep step){
        this.setLayout(new BorderLayout());
        this.add(new JLabel(step.getIndex()+":"), BorderLayout.WEST);
        this.add(new NumberMatrixPanel(step.getInterimSolution()), BorderLayout.CENTER);
        this.add(new JLabel(step.getExplanation()), BorderLayout.NORTH);


        this.setVisible(true);
    }

}
