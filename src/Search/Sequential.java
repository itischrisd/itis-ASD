package Search;

public class Sequential {

    public static int search(int[] arr, int len, int key) {
        int i = 0;              // 1
        while (i < len) {       // n
            if (key == arr[i])  // n
                return i;       // 0 lub 1
            i++;                // n
        }
        return -1;              // 0 lub 1
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie klucza z elementem ciągu
    R.D.: długość ciągu arr
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)

        POPRAWNOŚĆ
    Właśność stopu: algorytm zatrzyma się, gdy i == len, i w każdej iteracji zwiększane jest o 1, len jest skończoną,
    stałą liczbą naturalną. Stąd wartość len zostanie osiągnięta przez i w skończonej liczbie iteracji.

    Poprawność częściowa:
    Niezmiennik pętli: dla każdego naturalnego j należącego do [0;i) arr[j] != key
    1. Krok bazowy.
    Przed pierwszą iteracją pętli i == 0, więc [0;0) jest zbiorem pustym. Nie ma w nim więc elementu j, takiego, że
    arr[j] == key.
    2. Założenie indukcyjne.
    W k-tej iteracji pętli dla wszystkich całkowitych j w zbiorze [0;i) arr[j] != key.
    3. Krok indukcyjny.
    Teza indukcyjna:
    W (k+1)-ej iteracji pętli dla wszystkich całkowitych j w zbiorze [0;i`) arr[j] != key.
    Dowód indukcyjny:
    W k+1-ej iteracji pętli jeśli arr[i] == key, to program wyjdzie z pętli. Wartość i` równa będzie dalej i, więc na
    mocy założenia indukcyjnego zbiór [0;i`) == [0;i) => żaden liczba całkowita z tego zbioru nie będzie indeksem
    poszukiwanego elementu. W drugim przypadku, gdy arr[i] != key, to i` = i + 1. Ma to miejsce jednak tylko, gdy
    warunek arr[i] != key został spełniony, prawdziwe jest zatem stwierdzenie, że zbiór [0;i] również nie zawiera
    indeksu, pod którym jest key. Prawdziwe jest zatem stwierdzenie, że poszukiwanego indeksu (liczby całkowitej) j nie
    ma w zbiorze [0;i`), gdyż i` == i +1).
 */