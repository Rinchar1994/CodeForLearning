package main.java.NowCoder.NowCoderCode1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _40_FindNumsAppearOnece {
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        int flag = 1;
        while ((temp & flag) == 0)
            flag <<= 1;
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            if((array[i] & flag) == 0) list1.add(array[i]);
            else list2.add(array[i]);
        }
        num1[0] = 0; num2[0] = 0;
        for(int i = 0; i < list1.size(); i++) {
            num1[0] ^= list1.get(i);
        }
        for(int i = 0; i < list2.size(); i++) {
            num2[0] ^= list2.get(i);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] b = new int[1], c = new int[1];
        FindNumsAppearOnce(a, b, c);
    }
}
