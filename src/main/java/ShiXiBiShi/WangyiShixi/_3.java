package main.java.ShiXiBiShi.WangyiShixi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Rinchar on 2018/3/28.
 */
public class _3 {
    /*将m个人物的能力放进map中，使得时间复杂度从N^2降低到N*/
    /*
    * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，
    * 牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，
    * 牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
    */
    /*
    * 每个输入包含一个测试用例。
    * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
    * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
    * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
    * 保证不存在两项工作的报酬相同。
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t1 = 0, t2 = 0;
        HashMap<Integer, Integer> hs = new HashMap<>(m + n);
        int[] a = new int[n + m];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            t1 = sc.nextInt();
            t2 = sc.nextInt();
            a[i] = t1;
            hs.put(t1, t2);
        }
        for (int i = 0; i < m; i++) {
            t1 = sc.nextInt();
            a[n + i] = t1;
            b[i] = t1;
            if (!hs.containsKey(t1))
                hs.put(t1, 0);
        }
        Arrays.sort(a);
        int max = 0;
        for (int i = 0; i < m + n; i++) {
            max = Math.max(max, hs.get(a[i]));
            hs.put(a[i], max);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(hs.get(b[i]));
        }
    }
}
