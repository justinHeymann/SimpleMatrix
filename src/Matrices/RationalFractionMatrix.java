package Matrices;

import MatrixMath.SimpleRationalFractionGauss;
import MatrixMath.StepByStepSolution;
import Util.RationalFraction;
import Exception.IllegalMatrixException;


public class RationalFractionMatrix extends NumberMatrix implements StepByStepSolution {
    private String[] lastSolution;
    private final SimpleRationalFractionGauss rationalFractionGauss = new SimpleRationalFractionGauss();

    public static void main(String[] args) throws IllegalMatrixException {
        RationalFractionMatrix test1 = new RationalFractionMatrix(2,4);
        RationalFractionMatrix edgeCase = new RationalFractionMatrix(3, 4);
        edgeCase.setRow(0, new Number[] {new RationalFraction(5, 9), new RationalFraction(0,1), new RationalFraction(0,1), new RationalFraction(0,1)});
        edgeCase.setRow(1, new Number[]{new RationalFraction(4, 1), new RationalFraction(0,1), new RationalFraction(2,6), new RationalFraction(1,10)});
        edgeCase.setRow(2, new Number[] {new RationalFraction(9,1), new RationalFraction(3,9), new RationalFraction(3,8), new RationalFraction(4,7)});

        System.out.println(test1.shorten());
        System.out.println(test1.gauss().shorten());
    }
    public RationalFractionMatrix(int rows, int columns, Number defaultValue) {
        super(rows, columns, defaultValue);
    }

    public RationalFractionMatrix(NumberMatrix copy) {
        super(copy);
    }

    public RationalFractionMatrix(int rows, int columns){
        super(rows, columns, 0);
        initRandom();
    }

    //shortens all fraction entries
    public RationalFractionMatrix shorten(){
        RationalFractionMatrix out = new RationalFractionMatrix(this);
        for(int i = 0; i < rows(); i++){
            for(int j = 0; j < columns(); j++){
                RationalFraction fraction = (RationalFraction) get(i, j);
                out.set(i, j, fraction.shorten());
            }
        }
        return out;
    }

    //init random
    private void initRandom(){
        for(int i = 0; i < rows(); i++){
            for(int j = 0; j < columns(); j++){
                set(i,j, new RationalFraction());
            }
        }
    }

    public RationalFractionMatrix gauss(){
        RationalFractionMatrix out = rationalFractionGauss.gauss(this).shorten();
        lastSolution = rationalFractionGauss.getSolution();
        return out;
    }

    //calc
    @Override
    public Class getType() {
        return RationalFraction.class;
    }

    @Override
    public String[] getSolution() {
        return lastSolution;
    }
}
