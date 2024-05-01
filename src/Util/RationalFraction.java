package Util;

import jdk.jfr.Unsigned;

import java.util.Random;

public class RationalFraction extends Number implements Comparable<RationalFraction>{
    private final long dividend;
    @Unsigned
    private final long divisor;

    public static void main(String[] args){
        RationalFraction test1 = new RationalFraction().shorten();
        RationalFraction test2 = new RationalFraction().shorten();

        System.out.println(test1+" "+test2);
        System.out.println("compare "+test1.doubleValue()+" to "+test2.doubleValue()+" : "+test1.compareTo(test2));

    }

    public RationalFraction(long dividend, long divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can not be 0: ");
        } else if (divisor < 0) {
            if (dividend < 0){
                this.divisor = Math.abs(divisor);
                this.dividend = Math.abs(dividend);
            }else {
                this.dividend = -dividend;
                this.divisor = Math.abs(divisor);
            }
        }else{
            this.divisor = divisor;
            this.dividend = dividend;
        }
    }

    public RationalFraction(long dividend){
        this(dividend, 1);
    }

    public RationalFraction(){
        Random rng = new Random();
        dividend = rng.nextInt(10);
        divisor = rng.nextInt(10) +1;
    }
    
    public RationalFraction(RationalFraction copy){
        this(copy.getDividend(), copy.getDivisor());
    }

    //number
    @Override
    public int intValue() {
        return (int) (getDividend() / getDivisor());
    }

    @Override
    public long longValue() {
        return getDividend() / getDivisor();
    }

    @Override
    public float floatValue() {
        return (float) getDividend() / getDivisor();
    }

    @Override
    public double doubleValue() {
        return (double) getDividend() / getDivisor();
    }
    
    //calc 
    public RationalFraction shorten(){
        if (getDividend() == 0) {
            return new RationalFraction(0, 1);
        }
        long gcd = new EuclideanAlgorithm().gcd(getDividend(), getDivisor());
        return new RationalFraction(getDividend() / gcd, getDivisor() / gcd);
    }

    public RationalFraction add(RationalFraction other) {

        if (this.getDivisor() == other.getDivisor()){
            return new RationalFraction(this.getDividend() + other.getDividend(), this.getDivisor());
        }

        return new RationalFraction(this.getDividend() * other.getDivisor() + this.getDivisor() * other.getDividend(), this.getDivisor() * other.getDivisor()).shorten();
    }

    public RationalFraction add(int i){
        return new RationalFraction(getDividend() + i * getDivisor(), getDivisor());
    }

    public RationalFraction multiply(int i){

        return new RationalFraction(getDividend() * i, getDivisor()).shorten();
    }

    public RationalFraction multiply(RationalFraction other){
        return new RationalFraction(other.getDividend() * this.getDividend(), other.getDivisor() * this.getDivisor()).shorten();
    }

    public RationalFraction divide(RationalFraction other){
        return multiply(new RationalFraction(other.getDivisor(), other.getDividend()));
    }
    
    //getter
    public long getDividend(){
        return dividend;
    }
    
    public long getDivisor(){
        return divisor;
    }

    public boolean isZero(){
        return getDividend() == 0;
    }

    
    
    //Object
    @Override
    public String toString() {
        if (getDivisor() == 1) {
            return "" + getDividend();
        } else if (getDividend() == 0) {
            return "0";
        } else if (getDividend() == getDivisor()) {
            return "1";
        } else if (Math.abs(getDividend()) == getDivisor()){
            return "-1";
        }
        return getDividend()+"/"+getDivisor();
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() != this.getClass()){
            return false;
        }

        RationalFraction otherShortened = ((RationalFraction) o).shorten();
        RationalFraction thisShortened = this.shorten();

        return (thisShortened.getDividend() == otherShortened.getDividend()) && (thisShortened.getDivisor() == otherShortened.getDivisor());
    }

    @Override
    public int compareTo(RationalFraction other) {
        double difference = (double) getDividend() /getDivisor() - (double) other.getDividend() /other.getDivisor();
        if (difference < 0.0 && difference> -1.0){
            return -1;
        } else if (difference > 0.0 && difference < 1) {
            return 1;
        }
        return (int) difference;
    }
}
