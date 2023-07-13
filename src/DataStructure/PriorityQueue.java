package DataStructure;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

    List<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
        heap.add(-1);
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public void construct(int[] arr) {
        heap.clear();
        heap.add(-1);
        int i = 0;
        while (i < arr.length) {
            heap.add(arr[i]);
            upheap(heap.size() - 1);
            i++;
        }
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(nlog(n))
    A(n) = O(nlog(n))
    S(n) = O(n)
    */

    public void fastConstruct(int[] arr) {
        heap.clear();
        heap.add(-1);
        for (int k : arr) heap.add(k);
        for (int j = heap.size() / 2; j > 0; j--)
            downheap(j);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(n)
    */

    public int insert(int value) {
        heap.add(value);
        upheap(heap.size() - 1);
        return heap.indexOf(value);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public int findMin() {
        if (heap.isEmpty())
            throw new IllegalStateException("Heap is empty.");
        return heap.get(1);
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public int delMin() {
        if (heap.isEmpty())
            throw new IllegalStateException("Heap is empty.");
        int toRet = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        downheap(1);
        return toRet;
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public void print() {
        int height = (int) (Math.log(heap.size() - 1) / Math.log(2));
        int maxWidth = (int) Math.pow(2, height) * 3;

        for (int i = 1, level = 0; i < heap.size(); i++) {
            if (i == Math.pow(2, level)) {
                System.out.println();
                printSpaces(maxWidth - (int) Math.pow(2, level) * 3 - 8);
                level++;
            }
            if (level == 4) {
                System.out.printf("%-1d", heap.get(i));
            } else {
                System.out.printf("%-3d", heap.get(i));
            }
            printSpaces(3);
        }
        System.out.println();
    }
    /*
    O.D.: pobranie elementu ciągu
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    void upheap(int index) {
        int key = heap.get(index);
        int parent = index / 2;
        while (parent > 0 && heap.get(parent) > key) {
            heap.set(index, heap.get(parent));
            index = parent;
            parent /= 2;
        }
        heap.set(index, key);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    void downheap(int index) {
        int key = heap.get(index);
        int size = heap.size();

        while (index * 2 < size) {
            int child = 2 * index;
            if (child + 1 < size && heap.get(child + 1) < heap.get(child)) {
                child++;
            }
            if (heap.get(child) < key) {
                heap.set(index, heap.get(child));
                index = child;
            } else {
                break;
            }
        }
        heap.set(index, key);
    }
    /*
    O.D.: porównanie dwóch elementów
    R.D.: długość ciągu
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */
}
