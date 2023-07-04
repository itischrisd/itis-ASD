package DataStructure;

public class MergeablePriorityQueue extends DynamicPriorityQueue {

    public void merge(PriorityQueueBinaryHeap otherPQ) {
        otherPQ.heap.remove(0);
        heap.addAll(otherPQ.heap);
        int size = heap.size();
        for (int i = (size / 2) - 1; i >= 1; i--) {
            downheap(i);
        }
    }
}
