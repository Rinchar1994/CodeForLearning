package main.java.BiShi.AiqiyiShiXi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/19.
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        int len = temp.length();
        if(len == 0) System.out.println("");
        StringBuilder re = new StringBuilder();
        char ch = temp.charAt(len - 1);
        for(int i = len - 1; i >= 0; i--) {
            if(temp.charAt(i) >= ch) re.append(String.valueOf(temp.charAt(i)));
        }
        System.out.println(re.toString());
    }
}
