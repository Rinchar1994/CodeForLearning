package main.java.LeetCode2;

import main.java.LeetCodeUtil.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/27.
 */
public class _56_MergeIntervals {
    //56. Merge Intervals (Medium) 38.35%
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start < b.start) return -1;
                else if (a.start > b.start) return 1;
                else return 0;
            }
        });
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end < intervals.get(i + 1).start) continue;
            else if (intervals.get(i).end < intervals.get(i + 1).end) {
                intervals.get(i).end = intervals.get(i+1).end;
                intervals.remove(i + 1);
                i--;
            } else if (intervals.get(i).end >= intervals.get(i + 1).end) {
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        int[][] a = {{3, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<Interval> haha = merge(Interval.initialList(a));
        System.out.println(Interval.listToString(haha));
    }
}
