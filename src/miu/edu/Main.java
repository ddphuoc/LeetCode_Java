package miu.edu;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(romanToInt("XXIV"));
    }

    /*
    *   Given a signed 32-bit integer x, return x with its digits reversed.
    *   If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
     */
    public static int reverse(int x) {
        if(x == 0 || x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE)
            return 0;
        int positive = x < 0 ? -1*x : x;
        if(positive < 10)
            return positive;
        long y = positive % 10;
        positive = positive / 10;
        while (positive / 10 > 0) {
            y = y * 10 + positive % 10;
            positive = positive / 10;
        }
        y = y * 10 + positive;
        if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
            return 0;

        return x < 0 ? (int)(-1 * y) : (int)y;
    }

    /*
    *   Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     */
    public static int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        int result = roman.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--) {
            Character c = s.charAt(i);
            Character previous = s.charAt(i + 1);
            if(c == 'I') {
                if(previous == 'V' || previous == 'X') {
                    result -= 1;
                }
                else {
                    result += 1;
                }
            } else if(c == 'X') {
                if(previous == 'L' || previous == 'C') {
                    result -= 10;
                }
                else {
                    result += 10;
                }
            } else if(c == 'C') {
                if(previous == 'D' || previous == 'M') {
                    result -= 100;
                }
                else {
                    result += 100;
                }
            } else {
                result += roman.get(c);
            }
        }
        return result;
    }

}
