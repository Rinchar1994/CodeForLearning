package main.java.BiShi;

import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/10/08
 **/
public class ToutiaoBiShi_1008_5 {

    private final static int INT = 10 ^ 9 + 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int[] badArr = new int[n];
        for (int i = 0; i < n; i++) {
            badArr[i] = in.nextInt();
        }

        int result = solution(m, a, b, badArr, n - 1);
        System.out.println(result);
    }

    private static int solution(int m, int a, int b, int[] badArr, int badPos) {
        if(m == 1) return 1;
        int minPos = m - b, maxPos = m - a;
        if(maxPos < 0) return 0;
        else if(minPos < 0) minPos = 0;

        while (badPos >= 0 && badArr[badPos] > maxPos) {
            badPos--;
        }

        if (badPos < 0 || badArr[badPos] < minPos) {
            int result = 0;
            for (int i = minPos; i <= maxPos; i++) {
                result += solution(i, a, b, badArr, badPos);
                result %= INT;
            }
            return result;
        } else {
            int result = 0;
            int t = badPos;
            while (t >= 0 && badArr[t] >= minPos) {
                t--;
            }
            int temp = t++;
            for (int i = minPos; i <= maxPos; i++) {
                if (i == badArr[t]) {
                    t++;
                    continue;
                }
                result += solution(i, a, b, badArr, temp);
                result %= INT;
            }
            return result;
        }
    }
}
