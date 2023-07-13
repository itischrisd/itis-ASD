package DataStructure;

public class DynamicPriorityQueue extends PriorityQueue {

    public void decreaseKey(int index, int newPriority) {
        if (index < 1 || index >= heap.size())
            throw new IllegalArgumentException("Invalid index");


        if (newPriority > heap.get(index))
            throw new IllegalArgumentException("New value is greater than current value");

        heap.set(index, newPriority);
        upheap(index);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public void delete(int index) {
        if (index < 1 || index >= heap.size())
            throw new IllegalArgumentException("Invalid index");

        decreaseKey(index, -1);
        delMin();
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */
}
