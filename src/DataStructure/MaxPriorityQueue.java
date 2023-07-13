package DataStructure;

import java.util.stream.Collectors;

public class MaxPriorityQueue extends PriorityQueue {

    public MaxPriorityQueue() {
        super();
    }

    @Override
    public void construct(int[] arr) {
        int[] inverted = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            inverted[i] = -arr[i];
        super.construct(inverted);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(nlog(n))
    A(n) = O(nlog(n))
    S(n) = O(n)
    */

    @Override
    public void fastConstruct(int[] arr) {
        int[] inverted = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            inverted[i] = -arr[i];
        super.fastConstruct(inverted);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(n)
    */

    @Override
    public int insert(int value) {
        value = -value;
        return super.insert(value);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public int findMax() {
        return - super.findMin();
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public int delMax() {
        return - super.delMin();
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    @Override
    public void print() {
        heap = heap.stream().map(e -> - e).collect(Collectors.toList());
        super.print();
        heap = heap.stream().map(e -> - e).collect(Collectors.toList());
    }
    /*
    O.D.: pobranie elementu ciągu
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */
}
