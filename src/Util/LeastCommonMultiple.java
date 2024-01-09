package Util;

public class LeastCommonMultiple {
    public static int lcm(int a, int b){
        if (a == 0 || b == 0) {
            return 0;
        }

        int abs1 = Math.abs(a);
        int abs2 = Math.abs(b);
        int absHigher = Math.max(abs1, abs2);
        int absLower = Math.min(abs1, abs2);
        int lcm = absHigher;
        while (lcm % absLower != 0) {
            lcm += absHigher;
        }
        return lcm;
    }
}
