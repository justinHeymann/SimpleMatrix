package Util;

public class EuclideanAlgorithm {
    public static void main(String[] args){
        EuclideanAlgorithm test = new EuclideanAlgorithm();
        test.gcdExtended(15, 401);
    }
    public int x;
    public int y;

    //simple recursive implementation of the Euclidean algorithm for gcd
    public long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    public int gcdExtended(int a, int b)
    {
        int x = 0;
        int y = 1;
        int lastx = 1;
        int lasty = 0;
        int r = 1;

        while (b != 0)
        {
            int q = a / b;
            r = a % b;

            a = b;
            b = r;

            int temp = x;
            x = lastx - q * x;
            lastx = temp;

            temp = y;
            y = lasty - q * y;
            lasty = temp;

            System.out.println(a+"\t"+b+"\t"+q+"\t"+r+"\t"+lasty+"\t"+lastx+"\t"+y+"\t"+x);
        }

        this.y = y;
        this.x = x;
        return r;

    }
}
