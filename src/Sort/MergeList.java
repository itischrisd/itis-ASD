package Sort;

import Container.Node;

public class MergeList {

    public static Node<Integer> sort(Node<Integer> list) {
        if (list == null || list.next == null)
            return list;

        Node<Integer> left, right;
        left = list;
        Node<Integer> slow = list;
        Node<Integer> fast = list.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        right = slow.next;
        slow.next = null;

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        Node<Integer> merged = new Node<>(-1);
        Node<Integer> current = merged;

        while (left != null && right != null) {
            if (left.value <= right.value) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return merged.next;
    }

    public static void printList(Node<Integer> list) {
        Node<Integer> current = list;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}

/*
        ZŁOŻONOŚĆ
    O.D.: porównanie dwóch elementów ciągu
    R.D.: długość ciągu arr
    W(n) = O(nlog(n))
    A(n) = O(nlog(n))
    S(n) = O(log(n)) (na ramki wywołań rekurencyjnych)

        POPRAWNOŚĆ
    Właśność stopu: Wywołania rekurencyjne zatrzymują się, gdy rozmiar listy wynosi 1. Na początku algorytmu, rozmiar
    listy jest większy niż 1. W każdej rekurencyjnej iteracji, rozmiar listy jest dzielony na pół, aż osiągnie
    rozmiar 1, wtedy algorytm zaczyna zamykać rekurencyjne wywołania. Zakańczając każdą parę rekurencyjnych wywołań,
    algorytm łączy dwie podlisty w jedną o długości równej sumie długości podlist (aż do osiągnięcia listy o
    długości listy wejściowej). Stąd wynika, że algorytm zawsze zatrzymuje się.

    Poprawność częściowa:
    Niezmiennik pętli: Po każdej iteracji pętli while w funkcji merge, elementy od początku listy do wskaźnika merged są
    już posortowane i tworzą jednolitą listę posortowaną.
    1. Krok bazowy.
    Przed rozpoczęciem pętli while, żadne elementy nie są jeszcze posortowane, merged nie wskazuje na żaden element
    listy, więc niezmiennik pętli jest spełniony.
    2. Założenie indukcyjne.
    Zakładamy, że niezmiennik pętli jest spełniony przed wykonaniem kolejnej iteracji pętli.
    3. Krok indukcyjny.
    Teza indukcyjna:
    Niezmiennik pętli jest spełniony po wykonaniu kolejnej iteracji pętli.
    Dowód indukcyjny:
    Podczas iteracji pętli while, porównujemy wartości left.value i right.value. Jeśli left.value jest mniejsze lub
    równe, przypisujemy left do merged i przechodzimy do kolejnego elementu w left. W przeciwnym przypadku przypisujemy
    right do merged i przechodzimy do kolejnego elementu w right. Po wykonaniu przypisania i przechodzeniu do kolejnego
    elementu, elementy o mniejszych wartościach są już połączone w jednolitą listę posortowaną do wskaźnika merged.
 */