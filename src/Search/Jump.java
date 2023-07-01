package Search;

public class Jump {

    public static int search(int[] arr, int len, int key) {
        int jump = (int) Math.sqrt(len);    // 1
        int i = jump - 1;                   // 1

        while (i < len - 1 && key > arr[i]) // sqrt(n)
            i += jump;                      // sqrt(n)

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
    Właśność stopu: algorytm zatrzyma się, gdy obie pętle zatrzymają się. Pierwsza pętla najpóźniej zakończy działanie,
    gdy wartość i przekroczy len - 1, która z kolei jest skończoną, stałą liczbą. W każdej iteracji piewrszej pętli i
    zwiększane jest o sqrt(len), przekroczy więc wartość len - 1 w skończonej liczbie iteracji. Druga pętla zatrzyma
    się, gdy j osiągnie wartość i - jump. Zmienna j inicjowana jest wartością i, a w każdej pętli zmniejszana jest o 1.
    W związku z tym musi zatrzymać się po skończonej ilości wykonań.

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
    W k+1-ej iteracji pętli jeśli key < arr[i], to program wyjdzie z pętli. Wartość i` równa będzie dalej i, więc na
    mocy założenia indukcyjnego zbiór S` == S => żadna liczba całkowita j z tego zbioru nie jest indeksem poszukiwanego
    elementu. W drugim przypadku, gdy key > arr[i], to i` = i + jump. Ma to miejsce jednak tylko, gdy warunek
    key > arr[i] został spełniony, prawdziwe jest zatem stwierdzenie, że zbiór [0;i - jump) powiększony prawostronnie o
    jump również nie zawiera indeksu, pod którym jest key. Wiedząc, że arr jest ciągiem niemalejącym, powiększenie
    wartości i o jump wynikowo da zbiór [0;i). Prawdziwe jest zatem stwierdzenie, że poszukiwanego indeksu (liczby
    całkowitej) j nie ma w zbiorze [0;i` - jump), ponieważ i` - jump == i.

    Niezmiennik 2. pętli: Przed rozpoczęciem k-tej iteracji elementy o indeksach większych niż i nie są równoważne
    poszukiwanemu elementowi.
    1. Krok bazowy.
    Przed rozpoczęciem pierwszej iteracji drugiej pętli (k=0), nie ma elementów o indeksach większych niż i. Zatem nie
    ma elementów, które należy sprawdzić, i nie ma elementów równych poszukiwanemu elementowi.
    2. Założenie indukcyjne.
    Przyjmujemy, że przed rozpoczęciem k-tej iteracji drugiej pętli (dla pewnego k > 0), elementy o indeksach większych
    niż i zostały już sprawdzone i nie są równoważne poszukiwanemu elementowi.
    3. Krok indukcyjny.
    Teza indukcyjna:
    Przed rozpoczęciem (k+1)-tej iteracji drugiej pętli (dla pewnego k > 0), elementy o indeksach większych
    niż i` zostały już sprawdzone i nie są równoważne poszukiwanemu elementowi.
    Dowód indykcujny:
    W k-tej iteracji drugiej pętli wykonujemy następujące kroki:
    a) Dekrementujemy wartość i, otrzymując i` = i - 1. To sprawia, że badamy poprzedni element w tablicy.
    b) Jeśli element o indeksie i` jest równy poszukiwanemu elementowi, algorytm zakończy działanie, zwracając indeks i`.
    W tym przypadku założenie indukcyjne jest spełnione, ponieważ wszystkie elementy o indeksach większych niż i`
    zostały już sprawdzone i nie są równoważne poszukiwanemu elementowi.
    c) Jeśli element o indeksie i` nie jest równy poszukiwanemu elementowi, kontynuujemy iteracje. Na mocy założenia
    indukcyjnego możemy być pewni, że żadne z elementów o indeksach większych niż i nie są równoważne poszukiwanemu
    elementowi, ponieważ zostały już sprawdzone. Zatem w (k+1)-tej iteracji również żaden z tych elementów nie będzie
    równy poszukiwanemu elementowi ani i`-temu elementowi. Dlatego niezmiennik pętli jest zachowany.
 */