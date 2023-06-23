package Sort;

import java.util.Arrays;

public class Merge {

    public static int[] sort(int[] arr, int len) {
        if (len > 1) {
            int m = len / 2;
            int[] arr1 = split(arr, 0, m);
            int[] arr2 = split(arr, m, len);
            return merge(sort(arr1, m), m,
                    sort(arr2, len - m), len - m);
        }
        return arr;
    }

    private static int[] merge(int[] arr1, int len1, int[] arr2, int len2) {
        System.out.println("Merging: " + Arrays.toString(arr1) + Arrays.toString(arr2));
        int i = 0;
        int j = 0;
        int[] arr = new int[len1 + len2];
        while (i < len1 && j < len2) {
           if (arr1[i] < arr2[j])
                arr[i + j] = arr1[i++];
            else
                arr[i + j] = arr2[j++];
        }
        while (i < len1)
                arr[i + j] = arr1[i++];
        while (j < len2)
                arr[i + j] = arr2[j++];
        System.out.println("Merged: " + Arrays.toString(arr));
        return arr;
    }

    private static int[] split(int[] arr, int l, int r) {
        return Arrays.copyOfRange(arr, l, r);
    }
}
