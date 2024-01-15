package Matrices;

import Util.RationalFraction;
import Matrices.NumberMatrix;

import java.util.Random;

public class RationalFractionMatrix extends NumberMatrix{
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

    //init random
    private void initRandom(){
        Random rng = new Random();
        for(int i = 0; i < rows(); i++){
            for(int j = 0; j < columns(); j++){
                set(i,j, new RationalFraction(rng.nextInt(100), rng.nextInt(100)));
            }
        }
    }

    public RationalFractionMatrix gauss(){
        return null;
    }
}
