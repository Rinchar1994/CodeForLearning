package main.java.BiShi.PinduoduoShiXi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Rinchar on 2018/4/26.
 */
public class Suanshu {
    public static int correct(String[] str) {
        Stack<Integer> stack = new Stack<>();
        if (str.length == 1) return Integer.parseInt(str[0]);
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("+")) continue;
            else if (str[i].equals("*")) {
                int temp = Integer.parseInt(str[i + 1]);
                temp *= stack.peek();
                stack.pop();
                stack.push(temp);
                i++;
            } else stack.push(Integer.parseInt(str[i]));
        }
        int re = 0;
        while (stack.size() > 0) {
            re += stack.peek();
            stack.pop();
        }
        return re;
    }

    public static int calculate(String[] str) {
        int re = 0;
        if (str.length == 1) return Integer.parseInt(str[0]);
        re = Integer.parseInt(str[0]);
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("+")) re += Integer.parseInt(str[i + 1]);
            else if (str[i].equals("*")) re *= Integer.parseInt(str[i + 1]);
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = in.nextInt();
        if (str.length() == 0) System.out.println("I");
        String[] a = str.split("[*//+]");
        String[] b = str.split("\\d+");
        String[] strArr = new String[a.length + b.length - (b.length == 0 ? 0 : 1)];
        for (int i = 0; i < a.length - 1; i++) {
            strArr[i * 2] = a[i];
            strArr[i * 2 + 1] = b[i + 1];
        }
        if (b.length != 0) strArr[a.length + b.length - 2] = a[a.length - 1];
        else strArr[0] = a[0];
        int reA = correct(strArr);
        int reB = calculate(strArr);
        if (reA == k && reB == k) System.out.println("U");
        else if (reA == k) System.out.println("M");
        else if (reB == k) System.out.println("L");
        else System.out.println("I");
    }
}