package main.java.ShiXiBiShi.PinduoduoShiXi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/3.
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int num = 2;
        int[][] a = new int[n][num];
        int j = 0;
        while(in.hasNextInt()) {
            a[j][0] = in.nextInt();
            a[j][1] = in.nextInt();
            j++;
        }
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++) {
            int low_i = a[i][0];
            int high_i = a[i][1];
            int dis = high_i - low_i;
            int current = low_i;
            for(int x=0;x<dis+1;x++) {
                if(m.containsKey(current)) {
                    int val = m.get(current);
                    val = val + 1;
                    m.put(current, val);
                }else {
                    m.put(current, 1);
                }
                current = current + 1;
            }
        }
        Iterator it = m.entrySet().iterator();
        Entry e = null;
        List<Integer> li = new ArrayList<Integer>();
        while(it.hasNext()) {
            e = (Entry) it.next();
            int val = (int) e.getValue();
            int key = (int)e.getKey();
            if(val>=k) {
                li.add(key);
            }
        }
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        if(li.size() != 0) {
            Iterator<Integer> arrit = li.iterator();
            while(arrit.hasNext()) {
                int cuInt = arrit.next();
                if(cuInt>maxVal) {
                    maxVal = cuInt;
                }
                if(cuInt<minVal) {
                    minVal = cuInt;
                }
            }
            System.out.println(minVal + " " + maxVal);
        }else {
            System.out.println("error");
        }
    }
}
