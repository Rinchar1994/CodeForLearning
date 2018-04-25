package main.java.NowCoder.NowCoderCode1;

/**
 * Created by Rinchar on 2018/4/25.
 */
public class _35_InversePairs {
    public static int InversePairs(int[] array) {
        if (array.length == 0) return 0;
        return InversePairsBin(array, 0, array.length - 1);
    }

    public static int InversePairsBin(int[] array, int head, int end) {
        int[] copy = new int[end - head + 1];
        if (end == head) return 0;
        if (end - head == 1) {
            if (array[head] > array[end]) {
                int temp = array[head];
                array[head] = array[end];
                array[end] = temp;
                return 1;
            } else return 0;
        }
        int mid = (head + end) / 2;
        int cnt = (InversePairsBin(array, head, mid) % 1000000007 + InversePairsBin(array, mid + 1, end) % 1000000007)
                % 1000000007;
        int index = copy.length - 1, i_left = mid, i_right = end;
        while (i_left >= head && i_right >= mid + 1) {
            if (array[i_left] > array[i_right]) {
                cnt = (cnt % 1000000007 + (i_right - mid) % 1000000007) % 1000000007;
                copy[index--] = array[i_left--];
            } else {
                copy[index--] = array[i_right--];
            }
        }
        if (i_right <= mid) {
            while (index >= 0) copy[index--] = array[i_left--];
        } else while (index >= 0) copy[index--] = array[i_right--];
        index = 0;
        for (int i = head; i <= end; i++)
            array[i] = copy[index++];
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(Integer.MIN_VALUE);

    }
}
