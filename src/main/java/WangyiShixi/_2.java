package main.java.WangyiShixi;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Rinchar on 2018/3/28.
 */
public class _2 {
    /*给定n,k，找出x mod y >= k的（x, y）的数量，其中0<=k<n, x,y <= n*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        if (n - 1 == k) System.out.println(0);
        BigDecimal a = new BigDecimal(n - k + 1);
        BigDecimal b = new BigDecimal(n - k);
        BigDecimal re = a.add(b).divide(new BigDecimal(2));
        if (n <= 2 * k) {
            System.out.println(re);
        } else if (k == 0) {
            System.out.println(b.multiply(b));;
        } else {
            /*思路是正方形中所有的点去掉X mod Y < k的情况，毕竟k < n / 2，这样情况少点*/
            int re_wrong = 0;
            for (int i = 0; i < k; i++) {
                for (int t = 1; t * k + i < n; t++) {
                    re_wrong += (n - t * k - i) / t;
                }
            }
            re = a.multiply(b).subtract(new BigDecimal(re_wrong));
            System.out.println(re);
        }
        /*int sum=0;
        for(int y=k;y<=n;y++) {
            sum+=(y-k)*(n/y);
            if(n%y-k>=0)
                sum+=n%y-k+1;
        }
        System.out.println(sum);*/
    }
}
