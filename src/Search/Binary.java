package Search;

public class Binary {

    public static int search(int[] arr, int len, int key) {
        int l = 0;                  // 1
        int r = len - 1;            // 1
        int m;                      // 1
        while (l <= r) {            // log(n)
            m = (l + r) / 2;        // log(n)
            if (key == arr[m])      // log(n)
                return m;           // 1
            if (key < arr[m])       // log(n)
                r = m - 1;          // log(n)
            else
                l = m + 1;          // log(n)
        }
        return -1;                  // 1
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie klucza z elementem ciągu
    R.D.: długość ciągu arr
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)

        POPRAWNOŚĆ
    Właśność stopu: algorytm zatrzyma się, gdy l > r (lub arr[m] == key). l i r inicjalizowane są jako skończone liczby
    naturalne. W każdej iteracji pętli jedna z nich nadpisywana połowę wartości między nimi +/- 1. Wartości ich więc
    zbliżają się ku sobie w każdej iteracji o nie mniej niż 1, niezależlnie od sumy ich wartości. Wynika z tego, że ich wartości
    muszą stać się równe w skończonej ilości iteracji, a w iteracji następnej po zrównaniu ich wartości l == r + 1 => l > 1.

    Poprawność częściowa:
    Niezmiennik pętli: dla każdego naturalnego j należącego do [0;i) arr[j] != key
    1. Krok bazowy.
    Przed pierwszą iteracją pętli i == 0, więc [0;0) jest zbiorem pustym. Nie ma w nim więc elementu j, takiego, że arr[j] == key.
    2. Założenie indukcyjne.
    W k-tej iteracji pętli dla wszystkich całkowitych j w zbiorze [0;i) arr[j] != key.
    3. Dowód indukcyjny.
    W k+1-ej iteracji pętli jeśli arr[i] == key, to program wyjdzie z pętli. Wartość i` równa będzie dalej i, więc na mocy
    założenia indukcyjnego zbiór [0;i`) == [0;i) => żaden liczba całkowita z tego zbioru nie będzie indeksem poszukiwanego
    elementu. W drugim przypadku, gdy arr[i] != key, to i` = i + 1. Ma to miejsce jednak tylko, gdy warunek arr[i] != key
    został spełniony, prawdziwe jest zatem stwierdzenie, że zbiór [0;i] również nie zawiera indeksu, pod którym jest key.
    Prawdziwe jest zatem stwierdzenie, że poszukiwanego indeksu (liczby całkowitej) j nie ma w zbiorze [0;i+1).
 */