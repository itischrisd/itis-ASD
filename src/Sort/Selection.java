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
        int min = i;                            // 1
        while (i < len) {                       // n
            if (arr[min] > arr[i])              // n
                min = i;                        // n
            i++;                                // n
        }
        return min;                             // 1
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];                     // 1
        arr[i1] = arr[i2];                      // 1
        arr[i2] = temp;                         // 1
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
    Teza indukcyjna:
    Po (k+1)-ej iteracji pętli zewnętrznej, najmniejsze k+1 elementów tablicy znajduje się na pozycjach arr[0] do
    arr[k] w kolejności niemalejącej.
    Dowód indukcyjny:
    Po (k+1)-ej iteracji pętli zewnętrznej, należy znaleźć najmniejszy element spośród arr[k+1:len) elementów. Wykonując
    operację swap(arr, i, min), znaleziony element zostanie przeniesiony na pozycję arr[i], a element na pozycji arr[i]
    zostanie przeniesiony na pozycję min. Zgodnie z założeniem indukcyjnym, najmniejsze k elementów znajduje się na
    pozycjach arr[0] do arr[k-1], więc również najmniejsze k+1 elementów znajdzie się na odpowiednich pozycjach. Dowodzi
    to poprawności częściowej algorytmu.
 */