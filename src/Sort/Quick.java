package Sort;

public class Quick {

    public static void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int k = partition(arr, l, r);
        sort(arr, l, k - 1);
        sort(arr, k + 1, r);

    }

    public static int partition(int[] arr, int l, int r) {
        int i = l + 1;
        int j = r;
        int p = arr[l];
        int temp;
        do {
            while ((i < r) && (arr[i] <= p)) i++;
            while ((j > i) && (arr[j] >= p)) j--;
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j);
        if (arr[i] > p) {
            arr[l] = arr[i - 1];
            arr[i - 1] = p;
            return i - 1;
        } else {
            arr[l] = arr[i];
            arr[i] = p;
            return i;
        }
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie dwóch elementów ciągu
    R.D.: długość ciągu arr
    W(n) = O(n^2)
    A(n) = O(nlog(n))
    S(n) = O(log(n)) (na ramki wywołań rekurencyjnych)

        POPRAWNOŚĆ
    Właśność stopu: Algorytm QuickSort gwarantuje zatrzymanie się, ponieważ przy każdym rekurencyjnym wywołaniu dzielimy
    tablicę na dwie mniejsze części, a warunek stopu to l >= r, czyli gdy lewa granica jest większa lub równa prawej
    granicy. Każde kolejne rekurencyjne wywołanie działa na mniejszych podproblemach, aż do momentu, gdy podproblemem
    staje się tablica o jednym lub zerowym rozmiarze, co jest warunkiem zakończenia rekurencji. Dzięki temu algorytm
    QuickSort zatrzymuje się dla każdej poprawnie zdefiniowanej tablicy wejściowej.

    Poprawność częściowa:
    Niezmiennik pętli: Elementy tablicy arr od indeksu l do i-1 są mniejsze lub równe elementowi p (pivocie), a elementy
    od indeksu i+1 do j są większe lub równe elementowi p.
    1. Krok bazowy.
    Przed rozpoczęciem pętli do-while, i jest inicjalizowane jako l + 1, j jako r, a element p jest wybrany jako pivot.
    Na tym etapie, żadne elementy przed l i po r nie są jeszcze uporządkowane, więc niezmiennik pętli jest spełniony.
    2. Założenie indukcyjne.
    Zakładamy, że niezmiennik pętli jest spełniony przed wykonaniem kolejnej iteracji pętli.
    3. Krok indukcyjny.
    W pętli do-while iterujemy przez tablicę, inkrementując i i dekrementując j. W każdej iteracji, sprawdzamy czy
    arr[i] jest mniejsze lub równe p i czy arr[j] jest większe lub równe p. Jeśli warunki są spełnione, zamieniamy
    elementy arr[i] i arr[j], aby umieścić mniejsze elementy po lewej stronie pivota, a większe elementy po prawej
    stronie pivota. Po wykonaniu zamiany, mamy pewność, że elementy od indeksu l do i-1 są mniejsze lub równe p, a
    elementy od indeksu i+1 do j są większe lub równe p. Pętla do-while kontynuuje, dopóki i jest mniejsze od j. Gdy
    warunek i < j nie jest spełniony, wtedy przerywamy pętlę. W zależności od wartości arr[i] w punkcie zakończenia
    pętli, zamieniamy wartość p z odpowiednim elementem tablicy tak, aby elementy mniejsze od p znajdowały się po lewej
    stronie, a większe po prawej stronie. Zwracamy indeks i jako miejsce, w którym znajduje się pivot.
 */