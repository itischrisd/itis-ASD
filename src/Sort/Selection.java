package Sort;

public class Selection {

    public static void sort(int[] arr, int len) {
        int i = 0;                              // 1
        while (i < len) {                       // n
            int min = indexOfMin(arr, i, len);  // n
            swap(arr, i, min);                  // n
            i++;                                // n
        }
    }

    private static int indexOfMin(int[] arr, int i, int len) {
        int min = i;                            // n
        while (i < len) {                       // n^2
            if (arr[min] > arr[i])              // n^2
                min = i;                        // n^2
            i++;                                // n^2
        }
        return min;                             // n
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];                     // n
        arr[i1] = arr[i2];                      // n
        arr[i2] = temp;                         // n
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie dwóch elementów ciągu
    R.D.: długość ciągu arr
    W(n) = O(n^2)
    A(n) = O(n^2)
    S(n) = O(1)

        POPRAWNOŚĆ
    Właśność stopu: algorytm zatrzyma się, gdy i == len, i w każdej iteracji zwiększane jest o 1, len jest skończoną,
    stałą liczbą naturalną. Stąd wartość len zostanie osiągnięta przez i w skończonej liczbie iteracji.

    Poprawność częściowa:
    Niezmiennik pętli: Po i-tej iteracji pętli zewnętrznej, najmniejsze i elementów tablicy znajduje się w posortowanym
    podciągu arr[0:i].
    1. Krok bazowy.
    Przed pierwszą iteracją pętli zewnętrznej, i = 0. Na tym etapie tablica nie jest jeszcze posortowana, więc w
    arr[0:0] znajduje się 0 najmniejszych elementów.
    2. Założenie indukcyjne.
    Załóżmy, że po k-tej iteracji pętli zewnętrznej, najmniejsze k elementów tablicy znajduje się na pozycjach arr[0] do
    arr[k-1] w kolejności niemalejącej.
    3. Krok indukcyjny.
    Po (k+1)-ej iteracji pętli zewnętrznej, należy znaleźć najmniejszy element spośród arr[k+1:len) elementów. Wykonując
    operację swap(arr, i, min), znaleziony element zostanie przeniesiony na pozycję arr[i], a element na pozycji arr[i]
    zostanie przeniesiony na pozycję min. Zgodnie z założeniem indukcyjnym, najmniejsze k elementów znajduje się na
    pozycjach arr[0] do arr[k-1], więc również najmniejsze k+1 elementów znajdzie się na odpowiednich pozycjach. Dowodzi
    to poprawności częściowej algorytmu.
 */