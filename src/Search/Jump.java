package Search;

public class Jump {

    public static int search(int[] arr, int len, int key) {
        int jump = (int) Math.sqrt(len);    // 1
        int i = jump - 1;                   // 1
        while (i < len - 1 && key > arr[i]) {     // sqrt(n)
                i += jump;                  // sqrt(n)
        }
        int j = i;                          // 1
        while (j != i - jump) {             // sqrt(n)
            if (key == arr[j])              // sqrt(n)
                return j;                   // 0 lub 1
            j--;                            // sqrt(n)
        }
        return -1;                          // 0 lub 1
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie klucza z elementem ciągu
    R.D.: długość ciągu arr
    W(n) = O(sqrt(n))
    A(n) = O(sqrt(n))
    S(n) = O(1)

        POPRAWNOŚĆ
    Właśność stopu: algorytm zatrzyma się, gdy obie pętle zatrzymają się. Pierwsza pętla najpóźniej zakończy działanie, gdy wartość i
    przekroczy len - 1, która z kolei jest skończoną, stałą liczbą. W każdej iteracji piewrszej pętli i zwiększane jest o
    sqrt(len), przekroczy więc wartość len - 1 w skończonej liczbie iteracji.

    Poprawność częściowa:
    Niezmiennik 1. pętli: key >= arr[i - jump]
    1. Krok bazowy.
    i0 = jump - 1 => arr[jump - 1 - jump] = arr[-1]
    2. Założenie indukcyjne.
    W k-tej iteracji pętli dla wszystkich całkowitych j w zbiorze S=[0;i - jump) arr[j] != key.
    3. Krok indukcyjny.
    Teza indukcyjna:
    W k+1-ej iteracji pętli dla wszystkich całkowitych j w zbiorze S=[0;i` - jump) arr[j] != key.
    Dowód indukcyjny:
    i' = i + jump, S' = S powiększony prawostronnie o jump
    W k+1-ej iteracji pętli jeśli key < arr[i], to program wyjdzie z pętli. Wartość i` równa będzie dalej i, więc na mocy
    założenia indukcyjnego zbiór S` == S => żadna liczba całkowita j z tego zbioru nie jest indeksem poszukiwanego
    elementu. W drugim przypadku, gdy key > arr[i], to i` = i + jump. Ma to miejsce jednak tylko, gdy warunek key > arr[i]
    został spełniony, prawdziwe jest zatem stwierdzenie, że zbiór [0;i - jump) powiększony prawostronnie o jump również
    nie zawiera indeksu, pod którym jest key.
   Wiedząc, że arr jest ciągiem niemalejącym, powiększenie wartości i o jump wynikowo da zbiór [0;
    Prawdziwe jest zatem stwierdzenie, że poszukiwanego indeksu (liczby całkowitej) j nie ma w zbiorze [0;i+1).
 */