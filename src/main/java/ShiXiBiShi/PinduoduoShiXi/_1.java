package main.java.ShiXiBiShi.PinduoduoShiXi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/3.
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*String[] a = in.nextLine().split(" ");
        int n = Integer.valueOf(a[0]), k = Integer.valueOf(a[1]);*/
        int n = in.nextInt(), k = in.nextInt();
        if (k > n) System.out.println("error");
        int[] low_i = new int[n], high_i = new int[n];
        HashMap<Integer, Integer> lo_map = new HashMap<>();
        HashMap<Integer, Integer> hi_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            low_i[i] = in.nextInt();
            high_i[i] = in.nextInt();
            lo_map.put(low_i[i], high_i[i]);
            hi_map.put(high_i[i], low_i[i]);
        }
        Arrays.sort(low_i);
        Arrays.sort(high_i);
        for (int i = k; i < n; i++) {
            int hi = lo_map.get(low_i[i]);

        }
    }
}
