package GUI;

import Util.RationalFraction;

public class TextInputParser {
    public static RationalFraction stringToFraction(String text){
        if (text.isBlank()){
            throw new IllegalArgumentException("Can not parse empty string");
        }
        if (!text.matches("[:space]*-?[0-9]+(/[0-9]*)?[:space]*")){
            throw new IllegalArgumentException("String does not match the required form");
        }
        String[] fraction = text.split("/");
        long dividend = Long.parseLong(fraction[0]);
        long divisor;
        if (fraction.length == 2){
            divisor = Long.parseLong(fraction[1]);
        }else {
            divisor = 1;
        }
        return new RationalFraction(dividend, divisor);
    }
}
