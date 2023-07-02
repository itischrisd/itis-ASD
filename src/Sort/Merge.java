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
        return arr;
    }

    private static int[] split(int[] arr, int l, int r) {
        return Arrays.copyOfRange(arr, l, r);
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie dwóch elementów ciągu
    R.D.: długość ciągu arr
    W(n) = O(nlog(n))
    A(n) = O(nlog(n))
    S(n) = O(n) (nie O(nlog(n)), ponieważ podtablice nie istnieją równocześnie, są zwalniane po wywołaniu rek.)

        POPRAWNOŚĆ
    Właśność stopu: Wywołania rekurencyjne zatrzymują się, gdy rozmiar tablicy wynosi 1. Na początku algorytmu, rozmiar
    tablicy jest większy niż 1. W każdej rekurencyjnej iteracji, rozmiar tablicy jest dzielony na pół, aż osiągnie
    rozmiar 1, wtedy algorytm zaczyna zamykać rekurencyjne wywołania. Zakańczając każdą parę rekurencyjnych wywołań,
    algorytm łączy dwie podtablice w jedną o długości równej sumie długości podtablic (aż do osiągnięcia tablicy o
    długości tablicy wejściowej). Stąd wynika, że algorytm zawsze zatrzymuje się.

    Poprawność częściowa:
    Niezmiennik pętli: Dla każdego indeksu j należącego do [0,i) wartość arr[j] jest na swoim właściwym miejscu w
    posortowanej części tablicy arr[0:i).
    1. Krok bazowy.
    Przed rozpoczęciem sortowania przez scalanie, tablica o długości 1 jest uważana za posortowaną. Algorytm kończy
    działanie bez żadnej operacji.
    2. Założenie indukcyjne.
    Przed rozpoczęciem każdej iteracji pętli, załóżmy, że podtablice, które mają być scalane, są posortowane.
    3. Krok indukcyjny.
    Teza indukcyjna:
    Po zakończeniu iteracji pętli, mamy większą posortowaną tablicę, która jest wynikiem scalania podtablic.
    Dowód indukcyjny:
    Podczas scalania, elementy z dwóch podtablic są porównywane i umieszczane w odpowiedniej kolejności w wynikowej
    tablicy. Algorytm zachowuje właściwość posortowania podtablic, ponieważ porównuje tylko elementy z jednej podtablicy
    z drugą podtablicą, które są już posortowane.
 */