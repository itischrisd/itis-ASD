package DataStructure;

public class MergeablePriorityQueue extends DynamicPriorityQueue {

    public void merge(PriorityQueue otherPQ) {
        otherPQ.heap.remove(0);
        heap.addAll(otherPQ.heap);
        int size = heap.size();
        for (int i = (size / 2) - 1; i >= 1; i--) {
            downheap(i);
        }
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu wynikowego
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(n)
    */
}
