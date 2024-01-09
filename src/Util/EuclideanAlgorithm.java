package Util;

public class EuclideanAlgorithm {
    public int x;
    public int y;

    //simple recursive implementation of the Euclidean algorithm for gcd
    public int gcd(int a, int b){
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
        }

        this.y = y;
        this.x = x;
        return r;

    }
}
