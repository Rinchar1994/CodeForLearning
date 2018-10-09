package main.java.BiShi.PinduoduoShiXi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/8/30
 **/
public class division {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] aArray = a.trim().split(" ");
        int x = Integer.valueOf(aArray[0]), y = Integer.valueOf(aArray[1]);
        x = x % y;
        if (x == 0) {
            System.out.println("0 0");
        }
        List list = new ArrayList();
        while (true) {
            list.add(x);
            while (x < y) {
                x *= 10;
            }
            x = (x * 10) % y;
            if (x == 0) {
                System.out.println(list.size() - 1 + " 0");
                break;
            }
            if (list.contains(x)) {
                int temp = list.size() - list.indexOf(x);
                System.out.println(list.indexOf(x) + " " + temp);
                break;
            }
        }
    }
}
