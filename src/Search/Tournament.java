package Search;

public class Tournament {

    public static int second(int[] arr, int len) {
        int[] min = minimum(arr, 0, len - 1);
        return min[1];
    }


    private static int[] minimum(int[] arr, int l, int r) {
        int[] ret = new int[2];
        if (l == r) {
            ret[0] = arr[l];
            ret[1] = Integer.MAX_VALUE;
        }
        else {
            int m = (l + r) / 2;
            int[] l_min = minimum(arr, l, m);
            int[] r_min = minimum(arr, m + 1, r);
            if (l_min[0] < r_min[0]) {
                ret = l_min;
                ret[1] = Math.min(ret[1], r_min[0]);
            } else {
                ret = r_min;
                ret[1] = Math.min(ret[1], l_min[0]);
            }
        }
        return ret;
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie dwóch elementów ciągu
    R.D.: długość ciągu arr
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(log(n)) (na ramki wywołań rekurencyjnych)

        POPRAWNOŚĆ
    Właśność stopu: Wywołania rekurencyjne zatrzymują się, gdy rozmiar tablicy wynosi 1. Na początku algorytmu, rozmiar
    tablicy jest większy niż 1. W każdej rekurencyjnej iteracji, rozmiar tablicy jest dzielony na pół, aż osiągnie
    rozmiar 1, wtedy algorytm zaczyna zamykać rekurencyjne wywołania. Stąd wynika, że algorytm zawsze zatrzymuje się.

    Poprawność częściowa:
    Niezmiennik pętli: W każdej rekurencyjnej iteracji algorytmu, dla tablicy arr[l:r], minimalny element znajduje się
    pod indeksem ret[0], a drugi najmniejszy element (jeśli istnieje) znajduje się pod indeksem ret[1].
    1. Krok bazowy.
    Na początku algorytmu, tablica arr składa się z jednego elementu arr[l:r]. W tym przypadku minimalny element i drugi
    najmniejszy element są tym samym elementem, który znajduje się pod indeksem ret[0]. Nie ma innych elementów w
    przedziale arr[l:r], więc nie ma drugiego najmniejszego elementu poza indeksem ret[0]. Niezmiennik jest spełniony.
    2. Założenie indukcyjne.
    Załóżmy, że niezmiennik jest spełniony dla przedziału arr[l:m] i arr[m+1:r], gdzie m jest środkowym indeksem tablicy
    arr.
    3. Krok indukcyjny.
    W rekurencyjnej iteracji algorytmu, minimalne elementy w przedziałach arr[l:m] i arr[m+1:r] są obliczane
    rekurencyjnie jako l_min = minimum(arr, l, m) i r_min = minimum(arr, m+1, r). Porównując l_min[0] (minimalny element
    w arr[l:m]) i r_min[0] (minimalny element w arr[m+1:r]), możemy ustalić, który z nich jest mniejszy i przypisać go
    jako ret[0] (minimalny element w arr[l:r]). Następnie, sprawdzamy, czy l_min[0] jest mniejszy od r_min[0]. Jeśli
    tak, to drugi najmniejszy element znajduje się w przedziale arr[m+1:r] i pod indeksem ret[1], w przeciwnym przypadku
    znajduje się w przedziale arr[l:m] i również pod indeksem ret[1]. W obu przypadkach, niezmiennik jest spełniony dla
    przedziału arr[l:r].
 */