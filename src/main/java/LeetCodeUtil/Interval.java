package main.java.LeetCodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/27.
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public static List<Interval> initialList(int[][] a) {
        List<Interval> re = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            re.add(new Interval(a[i][0], a[i][1]));
        }
        return re;
    }

    public static String listToString(List<Interval> intervals) {
        String re = "";
        for (Interval interval : intervals) {
            re += "[" + interval.start + ", " + interval.end + "], ";
        }
        return re;
    }
}
