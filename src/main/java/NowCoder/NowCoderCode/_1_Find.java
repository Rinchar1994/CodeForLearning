package main.java.NowCoder.NowCoderCode;

import javax.print.attribute.standard.Finishings;

/**
 * Created by Rinchar on 2018/3/7.
 */
public class _1_Find {
    public static boolean Find(int target, int[][] array) {
        if(array.length == 0) return false;
        if(array[0].length == 0) return false;
        int end = array[0].length - 1;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j <= end; j++) {
                if(array[i][j] == target) return true;
                if (array[i][j] > target) {
                    end = j - 1;
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {2, 3, 4, 5}, {5, 6, 7, 8}};
        System.out.println(Find(3, a));
    }
}
