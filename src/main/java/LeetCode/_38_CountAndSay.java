package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _38_CountAndSay {
    //38. Count and Say (Easy) 15.04%
    public static String countAndSay(int n) {
        String re = "1";
        return convert(re, n);
    }

    public static String convert(String re, int n) {
        if (n == 1) return re;
        int cnt = 0;
        Character temp = '.';
        char[] charArr = re.toCharArray();
        re = "";
        for (Character key : charArr) {
            if (key != temp) {
                if (temp == '.') {
                    cnt++;
                } else {
                    re += String.valueOf(cnt) + String.valueOf(temp);
                    cnt = 1;
                }
                temp = key;
            } else cnt++;
        }
        re += String.valueOf(cnt) + String.valueOf(temp);
        return convert(re, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
