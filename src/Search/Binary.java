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
    Niezmiennik pętli:
    1. Krok bazowy.

    2. Założenie indukcyjne.

    3. Dowód indukcyjny.

 */