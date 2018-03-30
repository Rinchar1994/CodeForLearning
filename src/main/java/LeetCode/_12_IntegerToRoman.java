package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _12_IntegerToRoman {
    //12. Integer to Roman (Medium) 64.80%
    //罗马数字最多重复3次 C/X/I能放左边表示减
    public static String intToRoman(int num) {
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int pos = 0;
        String re = "";
        while (num != 0) {
            if (num >= value[pos]) {
                num -= value[pos];
                re += symbol[pos];
            } else {
                pos++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int num = 3999;
        System.out.println(intToRoman(num));
    }
}
