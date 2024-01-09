package Util;

public class RationalFraction extends Number implements Comparable<RationalFraction>{

    public static void main(String[] args){
        RationalFraction test1 = new RationalFraction(2, 4);
        RationalFraction test2 = new RationalFraction(1, 2);
        System.out.println(test1.equals(test2));
    }
    private final int dividend;
    private final int divisor;
    
    public RationalFraction(int dividend, int divisor){
        this.dividend = dividend;
        this.divisor = divisor;
    }
    
    public RationalFraction(RationalFraction copy){
        this(copy.getDividend(), copy.getDivisor());
    }

    @Override
    public int intValue() {
        return dividend / divisor;
    }

    @Override
    public long longValue() {
        return dividend / divisor;
    }

    @Override
    public float floatValue() {
        return dividend / divisor;
    }

    @Override
    public double doubleValue() {
        return dividend / divisor;
    }
    
    //calc 
    public RationalFraction shorten(){
        int dividend = getDividend();
        int divisor = getDivisor();

        int min = Integer.min(dividend, divisor);
        
        //TODO improve efficiency
        for(int i = min; i > 1; i--){
            if(dividend % i == 0 && divisor % i == 0){
                dividend = dividend / i;
                divisor = divisor / i;
                break;
            }
        }
        return new RationalFraction(dividend, divisor);
    }
    
    
    //getter
    public int getDividend(){
        return dividend;
    }
    
    public int getDivisor(){
        return divisor;
    }
    
    
    //Object
    @Override
    public String toString(){
        return dividend+"/"+divisor;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() != this.getClass()){
            return false;
        }

        RationalFraction otherShortened = new RationalFraction((RationalFraction) o);
        RationalFraction thisShortened = new RationalFraction(this);
        otherShortened = otherShortened.shorten();
        thisShortened = thisShortened.shorten();

        return (thisShortened.getDividend() == otherShortened.getDividend()) && (thisShortened.getDivisor() == otherShortened.getDivisor());
    }

    @Override
    public int compareTo(RationalFraction rationalFraction) {
        return dividend/divisor - rationalFraction.getDividend()/rationalFraction.getDivisor();
    }
}
