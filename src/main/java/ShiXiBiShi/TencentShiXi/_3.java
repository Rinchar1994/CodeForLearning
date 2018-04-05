package main.java.ShiXiBiShi.TencentShiXi;

import org.omg.CORBA.INTERNAL;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * Created by Rinchar on 2018/4/5.
 */
public class _3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Map<Integer, Integer> xy_map = new HashMap<>();
        Map<Integer, Integer> zw_map = new HashMap<>();
        int[] xi = new int[n], yi = new int[n];
        int[] zi = new int[m], wi = new int[m];
        for(int i = 0; i < n; i++) {
            xi[i] = in.nextInt();
            yi[i] = in.nextInt();
            xy_map.put(xi[i], yi[i]);
        }
        for(int i = 0; i < m; i++) {
            zi[i] = in.nextInt();
            wi[i] = in.nextInt();
            zw_map.put(zi[i], yi[i]);
        }
        int[][] re = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (xi[i] >= zi[j] && yi[i] >= wi[j]) {
                    re[i][j] = 1;
                }
            }
        }
        int[] flag = new int[n];
    }
}
