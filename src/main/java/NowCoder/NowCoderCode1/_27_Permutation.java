package main.java.NowCoder.NowCoderCode1;

import main.java.NowCoder.NowCoderUtil.ArrayPrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by Rinchar on 2018/4/9.
 */
public class _27_Permutation {
    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return new ArrayList<>();
        StringBuilder str_dup = new StringBuilder(str);
        HashSet<String> re_set = new HashSet<>();
        permutationRecursion(str_dup, 0, re_set);
        ArrayList<String> re = new ArrayList<>(re_set);
        Collections.sort(re, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) > 0) return 1;
                else return -1;
            }
        });
        return re;
    }

    public static void permutationRecursion(StringBuilder str, int p, HashSet<String> re) {
        if (p == str.length()) {
            re.add(str.toString());
        } else {
            for (int i = p; i < str.length(); i++) {
                String temp = str.substring(p, p + 1);
                str.replace(p, p + 1, str.substring(i, i + 1));
                str.replace(i, i + 1, temp);
                permutationRecursion(str, p + 1, re);
                temp = str.substring(p, p + 1);
                str.replace(p, p + 1, str.substring(i, i + 1));
                str.replace(i, i + 1, temp);
            }
        }
    }

    public static void main(String[] args) {
        String a = "aab";
        ArrayList<String> temp = _27_Permutation.Permutation(a);
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }
}
