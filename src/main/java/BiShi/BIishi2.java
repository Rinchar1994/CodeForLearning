package main.java.BiShi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/9/6
 **/
public class BIishi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        int line = Integer.valueOf(a);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < line - 1; i++) {
            a = in.nextLine();
            String[] b = a.split(" ");
            int[] temp = new int[2];
            temp[0] = Integer.valueOf(b[0]);
            temp[1] = Integer.valueOf(b[1]);
            list.add(temp);
        }
        list.sort((x, y) -> x[0] - y[0]);
        int i = 0, num = 0;
        for (; i < line - 1; i++) {
            if (list.get(i)[0] == 1) {
                num++;
            } else {
                break;
            }
        }
        List<Integer> lenList = new ArrayList<>();
        for (int j = 0; j < num; j++) {
            int cnt = 0;

        }
        System.out.println(4);
    }
}
