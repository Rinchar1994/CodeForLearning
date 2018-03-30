package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/10.
 */
public class _7_ReverseInteger {
    //7. Reverse Integer
    //需要注意超过int的maxvalue之后的情况
    public static int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        int pos_x = Math.abs(x);
        StringBuilder re_x = new StringBuilder();
        while (pos_x != 0) {
            re_x.append(Integer.toString(pos_x % 10));
            pos_x /= 10;
        }
        String re_x_str = re_x.toString();
        for(int i = 0; i < 10 - re_x_str.length(); i++) {
            re_x_str = "0" + re_x_str;
        }
        if (re_x_str.compareTo(Integer.toString(Integer.MAX_VALUE)) > 0) {
            return 0;
        }
        return x < 0 ? (0 - Integer.parseInt(re_x.toString())) : Integer.parseInt(re_x.toString());
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
