package Util;

import java.util.Random;

public class RationalFraction extends Number implements Comparable<RationalFraction>{
    private final int dividend;
    private final int divisor;
    public static void main(String[] args){
        RationalFraction test1 = new RationalFraction();
        RationalFraction test2 = new RationalFraction();

        System.out.println(test1+" "+test2);

        System.out.println(test1.add(test2).shorten());
        System.out.println(test1.multiply(test2).shorten());
    }

    public RationalFraction(int dividend, int divisor){
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public RationalFraction(){
        Random rng = new Random();
        dividend = rng.nextInt(100);
        divisor = rng.nextInt(100);
    }
    
    public RationalFraction(RationalFraction copy){
        this(copy.getDividend(), copy.getDivisor());
    }

    //number
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
        return (float) dividend / divisor;
    }

    @Override
    public double doubleValue() {
        return (double) dividend / divisor;
    }
    
    //calc 
    public RationalFraction shorten(){
        int gcd = new EuclideanAlgorithm().gcd(getDividend(), getDivisor());

        return new RationalFraction(getDividend() / gcd, getDivisor() / gcd);
    }

    public RationalFraction add(RationalFraction other) {

        if (this.getDivisor() == other.getDivisor()){
            return new RationalFraction(this.getDividend() + other.getDividend(), this.getDivisor());
        }

        int lcm = LeastCommonMultiple.lcm(this.getDivisor(), other.getDivisor());
        int otherMultiple = lcm / other.getDivisor();
        int thisMultiple = lcm / this.getDivisor();

        return new RationalFraction(this.getDividend() * thisMultiple + other.getDividend() * otherMultiple, lcm);
    }

    public RationalFraction add(int i){
        return new RationalFraction(getDividend() + i * getDivisor(), getDivisor());
    }

    public RationalFraction multiply(int i){
        return new RationalFraction(getDividend() * i, getDivisor());
    }

    public RationalFraction multiply(RationalFraction other){
        return new RationalFraction(other.getDividend() * this.getDividend(), other.getDivisor() * this.getDivisor());
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
        if (divisor == 1){
            return ""+dividend;
        }
        return dividend+"/"+divisor;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() != this.getClass()){
            return false;
        }

        RationalFraction otherShortened = new RationalFraction((RationalFraction) o).shorten();
        RationalFraction thisShortened = new RationalFraction(this).shorten();

        return (thisShortened.getDividend() == otherShortened.getDividend()) && (thisShortened.getDivisor() == otherShortened.getDivisor());
    }

    @Override
    public int compareTo(RationalFraction other) {
        return (int) Math.round( (double) dividend/divisor - (double) other.getDividend()/other.getDivisor());
    }
}
