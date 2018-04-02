package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.Interval;

import java.util.List;

/**
 * Created by Rinchar on 2017/10/29.
 */
public class _57_InsertInterval {
    //57. Insert Interval (Hard) 32.22%
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = -1, end = -1, start_flag = 0, end_flag = 0;
        intervals.add(0, new Interval(-1, -1));
        intervals.add(intervals.size(), new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
        for (int i = 0; i < intervals.size(); i++) {
            if (start == -1) {
                if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start) {
                    start = i;
                    start_flag = 1;
                } else if (i < intervals.size() - 1 && intervals.get(i).end < newInterval.start
                        && newInterval.start < intervals.get(i + 1).start) {
                    start = i;
                }
            }
            if (end == -1) {
                if (intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end) {
                    end = i;
                    end_flag = 1;
                } else if (i < intervals.size() - 1 && intervals.get(i).end < newInterval.end
                        && newInterval.end < intervals.get(i + 1).start) {
                    end = i;
                }
            }
            if (start != -1 && end != -1) break;
        }
        if (end_flag == 1) {
            for (int i = end - 1; i > start; i--) intervals.remove(i);
            if (start_flag == 1) {
                if (start != end) {
                    intervals.get(start).end = intervals.get(start + 1).end;
                    intervals.remove(start + 1);
                }
            } else intervals.get(start + 1).start = newInterval.start;
        } else if (end_flag == 0) {
            for (int i = end; i > start; i--) intervals.remove(i);
            if (start_flag == 0) intervals.add(start + 1, newInterval);
            else intervals.get(start).end = newInterval.end;
        }
        intervals.remove(0);
        intervals.remove(intervals.size() - 1);
        return intervals;
    }
}
