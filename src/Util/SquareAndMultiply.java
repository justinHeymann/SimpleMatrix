package Util;

public class SquareAndMultiply {
    public static void main(String[] args){
        System.out.println(squareAndMultiply(15, 399, 401));
    }

    public static int squareAndMultiply(int base, int exp, int mod){
        int x = 1;
        int y = base;
        int k = exp;
        while (k > 0){
            if(k % 2 == 1){
                //System.out.println(x+" * "+y+" % "+mod+" = "+(x * y) % mod);
                x = (x * y) % mod;
                --k;
            }
            y = (y * y) % mod;
            k = k / 2;
            System.out.println(x+"\t"+y+"\t"+k);
        }
        return x;
    }
}
