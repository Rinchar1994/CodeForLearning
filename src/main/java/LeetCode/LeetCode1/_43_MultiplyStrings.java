package main.java.LeetCode.LeetCode1;

/**
 * Created by Rinchar on 2017/10/23.
 */
public class _43_MultiplyStrings {
    //43. Multiply Strings (Medium) 78.32%
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder re = new StringBuilder();
        int len1 = num1.length(), len2 = num2.length();
        int[] mulArr = new int[len2 + len1];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int index = len1 + len2 - i - j - 2;
                mulArr[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                mulArr[index + 1] += mulArr[index] / 10;
                mulArr[index] %= 10;
            }
        }
        for(int i = mulArr.length - 1; i >= 0; i--) {
            if(re.length() == 0 && mulArr[i] == 0) continue;
            re.append(mulArr[i]);
        }
        return re.toString();
    }
}
