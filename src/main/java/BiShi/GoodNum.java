package main.java.BiShi;
import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/9/20
 **/
public class GoodNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        int aNum = Solution(a - 1);
        int bNum = Solution(b);
        System.out.println(bNum - aNum);
    }

    public static int Solution(int x) {
        if(x / 10 == 0) return x;
        int num = 9, level = 2, levelNum = 100;
        while (levelNum <= x) {
            int numTemp = 81;
            int nTemp = level / 2;
            for (int i = 1; i < nTemp; i++) {
                numTemp *= 90;
            }
            if (level % 2 == 1) {
                numTemp *= 10;
            }
            num += numTemp;
            level++;
            if (Integer.MAX_VALUE / 10 < levelNum) {
                break;
            }
            levelNum *= 10;
        }
        int begin = 0;
        if (x < levelNum) {
            begin = levelNum / 10;
        } else {
            begin = levelNum;
        }
        for (int i = begin; i <= x; i++) {
            String strTemp = Integer.toString(i);
            int len = strTemp.length();
            num++;
            for (int j = 0; j < len / 2; j++) {
                if (strTemp.charAt(j) == strTemp.charAt(len - j - 1)) {
                    num--;
                    break;
                }
            }
        }
        return num;
    }
}
