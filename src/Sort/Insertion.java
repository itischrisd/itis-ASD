package Sort;

public class Insertion {

    public static void sort(int[] arr, int len) {
        int i = 1;                                  // 1
        while (i < len) {                           // n
            int j = i;                              // n
            int temp = arr[i];                      // n
            while (j > 0 && temp < arr[j - 1]) {    // n^2
                arr[j] = arr[j - 1];                // n^2
                j--;                                // n^2
            }
            arr[j]  = temp;                         // n
            i++;                                    // n
        }
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
    Właśność stopu: algorytm zatrzyma się, gdy wykonanie zakończy zewnętrzna pętla. Wykona się ona, gdy wartość i będzie
    większa lub równa od len. i jest inicjowane wartością 1 i zwiększane w każdej iteracji. len jest liczbą całkowitą
    większą lub równą zero. Stąd wynika, że i stanie się większe lub równe len w skończonej liczbie iteracji. Jeśli sterowanie
    przepływu programu wejdzie do wewnętrznej pętli, to zakończy się ona, gdy co najmniej zmienna j osiągnie wartość mniejszą
    lub równą zero. j w każdej iteracji zewnętrznej pętli inicjowane jest wartością i (skończoną liczbą naturalną) i zmniejszane
    o 1 w każdej iteracji pętli wewnętrznej. Stąd wynika, że wewnętrzna pętla również zatrzyma się w skończonej liczbie
    iteracji.

    Poprawność częściowa:
    Niezmiennik pętli: Dla każdego indeksu j należącego do [0,i) wartość arr[j] jest na swoim właściwym miejscu w
    posortowanej części tablicy arr[0:i).
    1. Krok bazowy.
    Przed rozpoczęciem pętli i = 1. Wówczas tablica arr[0:1) składa się z jednego elementu, a niezmiennik pętli jest
    spełniony.
    2. Założenie indukcyjne.
    Załóżmy, że dla k-tej iteracji pętli (dla pewnego k > 1) niezmiennik pętli jest spełniony, czyli każdy element
    arr[j] dla j z zakresu [0, k) jest na właściwym miejscu w posortowanej części arr[0:k).
    3. Krok indukcyjny.
    Przeanalizujmy (k+1)-szą iterację pętli. Na początku tej iteracji arr[0:k] jest posortowane. Chcemy dodać element
    arr[k] na właściwe miejsce w posortowanej części arr[0:k+1).
    a) Przesuwamy elementy większe od arr[k] w prawo, aż znajdziemy odpowiednie miejsce dla arr[k]. W trakcie
    przesuwania elementów zachowujemy niezmiennik pętli, ponieważ dla każdego j z zakresu [k, i) arr[j] jest przesuwany
    na pozycję j+1, a pozostałe elementy arr[0:k] pozostają na swoich miejscach. Po tym kroku tablica arr[0:k+1) jest
    posortowana.
    b) Wstawiamy arr[k] na właściwe miejsce. Element arr[k] jest większy lub rówbny od wszystkich elementów arr[0:k),
    ale mniejszy lub równy arr[k+1:i]. Wstawienie arr[k] na właściwe miejsce oznacza, że niezmiennik pętli jest
    spełniony dla zakresu [1, k+1).
 */