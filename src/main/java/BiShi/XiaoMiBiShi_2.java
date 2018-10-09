package main.java.BiShi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/9/27
 **/
public class XiaoMiBiShi_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        if (N == 1) {
            if (N != M) System.out.println(0);
            else System.out.println(1);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            System.out.println(pinjie(0, 1, N, M, stringBuilder));
        }
    }

    private static int pinjie(int re, int i, int N, int M, StringBuilder stringBuilder) {
        if (i > N) {
            String str = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
            if (calculate(str) == M) {
                return ++re;
            }
        }
        stringBuilder.append(i);
        stringBuilder.append("+");
        re = pinjie(re,i + 1, N, M, stringBuilder);
        if(i == N) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            return re;
        }
        stringBuilder.replace(stringBuilder.lastIndexOf("+"), stringBuilder.lastIndexOf("+") + 1, "-");
        re = pinjie(re, i + 1, N, M, stringBuilder);
        stringBuilder.replace(stringBuilder.lastIndexOf("-"), stringBuilder.lastIndexOf("-"), " ");
        re = pinjie(re, i + 1, N, M, stringBuilder);
        return re;
    }

    private static int calculate(String str) {
        String[] strList = str.split("[+\\-]");
        for (int x = 0; x < strList.length; x++) {
            for (int i = 0; i < strList[x].length(); i++) {
                int len = strList[x].length();
                if (strList[x].charAt(i) == ' ') {
                    strList[x] = strList[x].substring(0, i) + strList[x].substring(i + 1, len);
                    i--;
                }
            }
        }
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                charList.add(str.charAt(i));
            }
        }
        int result = Integer.valueOf(strList[0]);
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i) == '+') {
                result += Integer.valueOf(strList[i + 1]);
            } else {
                result -= Integer.valueOf(strList[i + 1]);
            }
        }
        return result;
    }
}
