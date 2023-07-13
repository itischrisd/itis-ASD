package Sort;


import java.util.Arrays;

public class Radix {

    public static int[] sort(int[] arr, int len) {
        int m = maxValue(arr);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            arr = countSortWithExp(arr, len, exp);
        }
        return arr;
    }
    
    private static int[] countSortWithExp(int[] arr, int len, int exp) {
        int[] counts = new int[10];
        int[] result = new int[len];

        for (int i = 0; i < len; i++)
            counts[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            counts[i] += counts[i - 1];

        for (int i = len - 1; i >= 0; i--)
            result[--counts[(arr[i] / exp) % 10]] = arr[i];

        return result;
    }

    private static int maxValue(int[] arr) {
        return Arrays.stream(arr).max().orElse(0);
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: przypisanie wartości w tablicy
    R.D.: liczba cyfr w największym elemencie d, liczba elementów w tablicy n, zakres wartości cyfr k
    W(n,m) = O(d * (n + k))
    A(n,m) = O(d * (n + k))
    S(n,m) = O(n + k)
 */