package MatrixMath.StepByStepSolution;

import Matrices.NumberMatrix;

import java.util.ArrayList;
import java.util.Iterator;

public class StepByStepSolution implements Iterable<CalculationStep>{
    private int stepCount = 0;
    private final ArrayList<CalculationStep> solutionSteps = new ArrayList<>();

    //add
    public void add(String explanation, NumberMatrix interimSolution){
        if (solutionSteps.stream().map(CalculationStep::getInterimSolution).noneMatch(s -> s.equals(interimSolution))){
            solutionSteps.add(new CalculationStep(stepCount, explanation, interimSolution));
            stepCount++;
        }
    }

    //getter
    public int getStepCount(){
        return stepCount;
    }

    public CalculationStep getStep(int i){
        if (i < solutionSteps.size() -1){
            throw new IllegalArgumentException("Calculation step "+i+" does not exist");
        }
        return solutionSteps.stream().filter(s -> s.getIndex() == i).findFirst().orElseThrow();
    }

    public CalculationStep getFinalResult(){
        return new CalculationStep(stepCount+1, "final result:", solutionSteps.get(stepCount -1).getInterimSolution());
    }

    @Override
    public Iterator<CalculationStep> iterator() {
        return solutionSteps.iterator();
    }
}
