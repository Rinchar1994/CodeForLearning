package main.java.LeetCode.LeetCode2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rinchar on 2017/10/31.
 */
public class _60_PermutationSequence {
    //60. Permutation Sequence (Medium) 10.72%
    public static String getPermutation(int n, int k) {
        String re = "x";
        for (int i = 1; i <= n; i++) {
            re += String.valueOf(i);
        }
        int ele = 1, mul = 1;
        while (k > mul) {
            mul *= ++ele;
        }
        mul /= ele;
        for (int i = ele - 1; i >= 1; i--) {
            int temp = k / mul;
            if (temp * mul == k) {
                k = mul;
                temp--;
            } else k %= mul;
            char charTemp = re.charAt(n - i + temp);
            re = re.substring(0, n - i + temp) + re.substring(n - i + temp + 1);
            re = re.substring(0, n - i) + charTemp + re.substring(n - i);
            mul /= i;
        }
        return re.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 5));
        Map<String, String> a = new ConcurrentHashMap<>();
    }
}
