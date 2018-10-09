package main.java.BiShi._58ShiXi;

/**
 * Created by Rinchar on 2018/4/1.
 */
public class _1 {
    /*
    * 给定一个字符串和一个数字n，找出字符串中出现连续出现n次的子串（只能出现n次，n+1dou不行）
    */
    public static void play(String str, int num) {
        int slow = 0, fast = 0;
        if (str.length() == 0) return;
        char temp = str.charAt(0);
        while (fast < str.length()) {
            if (temp == str.charAt(fast)) {
                if (++fast >= str.length()) {
                    if (fast - slow == num) {
                        for (int i = 0; i < fast - slow - num + 1; i++) {
                            int begin = slow + 1, end = slow + num;
                            System.out.println("(" + begin + "," + end + ","
                                    + str.substring(slow, slow + num) + ")");
                        }
                    }
                    break;
                }
            } else {
                if (fast - slow == num) {
                    for (int i = 0; i < fast - slow - num + 1; i++) {
                        int begin = slow + 1, end = slow + num;
                        System.out.println("(" + begin + "," + end + ","
                                + str.substring(slow, slow + num) + ")");
                    }
                }
                slow = fast;
                temp = str.charAt(fast);
            }
        }
    }

    public static void main(String[] args) {
        String a = "abbcccddeefffgggcc";
        int num = 2;
        play(a, num);
    }
}
