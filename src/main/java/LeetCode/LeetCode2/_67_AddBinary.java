package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/7.
 */
public class _67_AddBinary {
    //67. Add Binary (Easy) 78.81%
    public static String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;
        if (a.length() < b.length()) return addBinary(b, a);
        String zero = "";
        for (int i = 0; i < a.length() - b.length(); i++) zero += "0";
        b = zero + b;
        char[] aArr = a.toCharArray(), bArr = b.toCharArray();
        int carry = 0;
        for (int i = aArr.length - 1; i >= 0; i--) {
            switch (carry + aArr[i] - '0' + bArr[i] - '0') {
                case 0:
                    break;
                case 1:
                    carry = 0;
                    aArr[i] = '1';
                    break;
                case 2:
                    carry = 1;
                    aArr[i] = '0';
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        String re = String.valueOf(aArr);
        if (carry == 1) re = "1" + re;
        return re;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
