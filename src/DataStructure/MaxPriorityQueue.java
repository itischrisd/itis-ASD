package DataStructure;

import java.util.stream.Collectors;

public class MaxPriorityQueue extends PriorityQueueBinaryHeap {

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

    @Override
    public void fastConstruct(int[] arr) {
        int[] inverted = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            inverted[i] = -arr[i];
        super.fastConstruct(inverted);
    }

    @Override
    public int insert(int value) {
        value = -value;
        return super.insert(value);
    }

    public int findMax() {
        return - super.findMin();
    }

    public int delMax() {
        return - super.delMin();
    }

    @Override
    public void print() {
        heap = heap.stream().map(e -> - e).collect(Collectors.toList());
        super.print();
        heap = heap.stream().map(e -> - e).collect(Collectors.toList());
    }
}
