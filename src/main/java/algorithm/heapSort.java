package main.java.algorithm;

import main.java.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2018/4/2.
 */
public class heapSort {
    public static void HeapAdjust(int[] arr, int parent, int len) {
        int child = parent * 2 + 1;
        while (child < len) {
            if (child + 1 < len && arr[child + 1] > arr[child]) {
                child++;
            }
            if (arr[parent] >= arr[child]) {
                break;
            }
            int temp = arr[child];
            arr[child] = arr[parent];
            arr[parent] = temp;
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void heapSort(int[] arr) {
        if (arr.length <= 1) return;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            HeapAdjust(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {91, 60, 96, 13, 35, 65, 46, 65, 10, 30, 20, 31, 77, 81, 22};
        heapSort(arr);
        System.out.println(ArrayPrint.intArrPrint(arr));
    }
}
