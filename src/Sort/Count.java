package Sort;

import java.util.Arrays;

public class Count {

    public static int[] sort(int[] arr, int len) {
        int count_len = maxValue(arr) + 1;
        int[] counts = new int[count_len];
        int[] result = new int[len];

        for (int i = 0; i < len; i++) counts[arr[i]]++;
        for (int i = 1; i < count_len; i++) counts[i] += counts[i - 1];
        for (int i = len - 1; i >= 0; i--)
            result[--counts[arr[i]]] = arr[i];

        return result;
    }

    public static int[] sortOnIntegers(int[] arr, int len) {
        int min = minValue(arr);
        int count_len = maxValue(arr) + 1 + Math.abs(min);
        int[] counts = new int[count_len];
        int[] result = new int[len];

        for (int i = 0; i < len; i++) counts[arr[i] - min]++;
        for (int i = 1; i < count_len; i++) counts[i] += counts[i - 1];
        for (int i = len - 1; i >= 0; i--)
            result[--counts[arr[i] - min]] = arr[i];

        return result;
    }

    private static int maxValue(int[] arr) {
        return Arrays.stream(arr).max().orElse(0);
    }

    private static int minValue(int[] arr) {
        return Arrays.stream(arr).min().orElse(0);
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: przypisanie wartości w tablicy
    R.D.: długość ciągu n, maksymalna wartość w ciągu m
    W(n,m) = O(n+m)
    A(n,m) = O(n+m)
    S(n,m) = O(n+m)
 */