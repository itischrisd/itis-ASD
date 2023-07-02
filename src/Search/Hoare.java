package Search;

import Sort.Quick;

public class Hoare {

    public static int kthSmallest(int[] arr, int len, int k) {
        int l = 0;
        int r = len - 1;
        int i = Quick.partition(arr, l, r);
        while (i != k) {
            if (i < k)
                l = i + 1;
            else
                r = i - 1;
            i = Quick.partition(arr, l, r);
        }
        return arr[i];
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie dwóch elementów ciągu
    R.D.: długość ciągu arr
    W(n) = O(nlog(n))
    A(n) = O(n)
    S(n) = O(1)
 */