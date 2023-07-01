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
    Niezmiennik pętli: Przed rozpoczęciem k-tej iteracji pętli wyszukiwania binarnego, elementy o indeksach mniejszych
    niż l i większych niż r nie są równoważne poszukiwanemu elementowi.
    1. Krok bazowy.
    Przed rozpoczęciem pierwszej iteracji pętli (k=0), nie ma żadnych elementów o indeksach mniejszych niż l i większych
    niż r. Zatem nie ma elementów, które należy sprawdzić, i nie ma elementów równych poszukiwanemu elementowi.
    2. Założenie indukcyjne.
    Przyjmujemy, że przed rozpoczęciem k-tej iteracji pętli (dla pewnego k > 0), elementy o indeksach mniejszych niż l i
    większych niż r zostały już sprawdzone i nie są równoważne poszukiwanemu elementowi.
    3. Dowód indukcyjny.
    W k-tej iteracji pętli wykonujemy operację podziału na połowę, obliczając indeks środkowy m jako (l + r) / 2.
    Istnieją trzy możliwe scenariusze:
    a) Jeśli element o indeksie m jest równy poszukiwanemu elementowi, algorytm zakończy działanie i zwróci indeks m.
    W tym przypadku założenie indukcyjne jest spełnione, ponieważ wszystkie elementy o indeksach mniejszych niż l i
    większych niż r zostały już sprawdzone i nie są równoważne poszukiwanemu elementowi.
    b) Jeśli element o indeksie m jest większy od poszukiwanego elementu, przesuwamy prawy indeks r na m - 1 i
    przechodzimy do następnej iteracji (k+1). Na mocy założenia indukcyjnego możemy być pewni, że wszystkie elementy o
    indeksach mniejszych niż l i większych niż r zostały już sprawdzone i nie są równoważne poszukiwanemu elementowi.
    Zatem w k-tej iteracji również żaden z tych elementów nie będzie równy poszukiwanemu elementowi.
    Dlatego niezmiennik pętli jest zachowany.
    c) Jeśli element o indeksie m jest mniejszy od poszukiwanego elementu, przesuwamy lewy indeks l na m + 1 i
    przechodzimy do następnej iteracji (k+1). Analogicznie jak w przypadku (b), założenie indukcyjne jest spełnione, a
    niezmiennik pętli jest zachowany.
 */