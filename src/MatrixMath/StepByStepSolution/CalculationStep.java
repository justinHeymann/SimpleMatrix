package MatrixMath.StepByStepSolution;

import Matrices.NumberMatrix;

/**
 * Wrapper class for a number matrix and a corresponding explanation for a given calculation step.
 * Enables implementation of Step-by-Step Solution
 */

public class CalculationStep implements Comparable<CalculationStep>{
    private final int index;
    private final String explanation;
    private final NumberMatrix interimSolution;
    public CalculationStep(int index, String explanation, NumberMatrix interimSolution){
        this.index = index;
        this.explanation = explanation;
        this.interimSolution = interimSolution;
    }

    public String getExplanation() {
        return explanation;
    }

    public NumberMatrix getInterimSolution() {
        return interimSolution;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(CalculationStep o) {
        return this.getIndex() - o.getIndex();
    }
}
