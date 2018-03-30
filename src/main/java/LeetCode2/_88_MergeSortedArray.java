package main.java.LeetCode2;

/**
 * Created by Rinchar on 2017/11/8.
 */
public class _88_MergeSortedArray {
    //88. Merge Sorted Array (Easy) 27.62%
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sum = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i == m) {
                sum[k] = nums2[j];
                j++;
                k++;
            } else if (j == n) {
                sum[k] = nums1[i];
                i++;
                k++;
            } else {
                if (nums1[i] <= nums2[j]) {
                    sum[k] = nums1[i];
                    i++;
                    k++;
                } else {
                    sum[k] = nums2[j];
                    j++;
                    k++;
                }
            }
        }
        for(int t = 0; t < sum.length; t++) {
            nums1[t] = sum[t];
        }
    }
}
