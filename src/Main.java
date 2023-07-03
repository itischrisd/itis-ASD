import DataStructure.PriorityQueueBinaryHeap;
import DataStructure.DLList;
import DataStructure.Node;
import Search.*;
import Sort.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        sequentialSearchTest();
        jumpSearchTest();
        binarySearchTest();
        tournamentTest();
        hoareTest();

        selectionSortTest();
        insertionSortTest();
        mergeSortTest();
        mergeSortListTest();
        quickSortTest();
        countSortTest();
        radixSortTest();

        DLListTest();
        priorityQueueTest();
    }

    private static void sequentialSearchTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        int len = arr.length;

        System.out.println("Sequentaial search");
        for (int i : arr)
            System.out.println("Found " + i + " at index: " + Sequential.search(arr, len, i));

        System.out.println("Not found 10, ret: " + Sequential.search(arr, len, 10));
        System.out.println("Not found 52, ret: " + Sequential.search(arr, len, 52));
        System.out.println("Not found 100, ret: " + Sequential.search(arr, len, 100));
    }

    private static void jumpSearchTest() {
        int[] arr = new int[]{19, 24, 28, 32, 50, 51, 54, 69, 73, 79, 80, 83, 84, 92, 95};
        int len = arr.length;

        System.out.println("\nJump search");
        for (int i : arr)
            System.out.println("Found " + i + " at index: " + Jump.search(arr, len, i));

        System.out.println("Not found 10, ret: " + Jump.search(arr, len, 10));
        System.out.println("Not found 52, ret: " + Jump.search(arr, len, 52));
        System.out.println("Not found 100, ret: " + Jump.search(arr, len, 100));
    }

    private static void binarySearchTest() {
        int[] arr = new int[]{19, 24, 28, 32, 50, 51, 54, 69, 73, 79, 80, 83, 84, 92, 95};
        int len = arr.length;

        System.out.println("\nBinary search");
        for (int i : arr)
            System.out.println("Found " + i + " at index: " + Binary.search(arr, len, i));

        System.out.println("Not found 10, ret: " + Binary.search(arr, len, 10));
        System.out.println("Not found 52, ret: " + Binary.search(arr, len, 52));
        System.out.println("Not found 100, ret: " + Binary.search(arr, len, 100));
    }

    public static void tournamentTest() {
        System.out.println("\nTournament algorithm");
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        int sec = Tournament.second(arr, arr.length);
        System.out.println("Second minimum: " + sec);
    }

    public static void hoareTest() {
        System.out.println("\nHoare algorithm");
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            System.out.println((i + 1) + " smallest: " + Hoare.kthSmallest(arr, len, i));
        }
    }

    private static void selectionSortTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        Selection.sort(arr, arr.length);
        System.out.println("\nSelection sorted: " + Arrays.toString(arr));
    }

    private static void insertionSortTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        Insertion.sort(arr, arr.length);
        System.out.println("\nInsertion sorted: " + Arrays.toString(arr));
    }

    private static void mergeSortTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        arr = Merge.sort(arr, arr.length);
        System.out.println("\nMerge sorted: " + Arrays.toString(arr));
    }

    private static void mergeSortListTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        Node<Integer> list = new Node<>(arr[0]);
        Node<Integer> curr = list;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node<>(arr[i]);
            curr = curr.next;
        }
        System.out.print("\nUnsorted list:\t\t");
        MergeList.printList(list);
        list = MergeList.sort(list);
        System.out.print("\nMerge sorted list:\t");
        MergeList.printList(list);
    }

    private static void quickSortTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        Quick.sort(arr, 0, arr.length - 1);
        System.out.println("\n\nQuick sorted: " + Arrays.toString(arr));
    }

    private static void countSortTest() {
        int[] arr = new int[]{2, 2, 3, 0, 1, 0, 2, 4, 3, 0};
        int[] sorted = Count.sort(arr, arr.length);
        System.out.println("\nCount sorted: " + Arrays.toString(sorted));
        int[] arr2 = new int[]{2, -2, 3, 0, -1, 0, 2, 4, 3, 0};
        int[] sorted2 = Count.sortOnIntegers(arr2, arr2.length);
        System.out.println("Count sorted: " + Arrays.toString(sorted2));
    }

    private static void radixSortTest() {
        int[] arr = new int[]{736, 124, 992, 384, 998, 111};
        arr = Radix.sort(arr, arr.length);
        System.out.println("\nRadix sorted: " + Arrays.toString(arr));
    }

    private static void DLListTest() {
        DLList<Integer> list = new DLList<>();

        System.out.println("\nDoubly Linked List");
        System.out.println("isEmpty: " + list.isEmpty());

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        System.out.println("first: " + list.first());

        System.out.println("last: " + list.last());

        System.out.println("Lista:");
        list.display();

        list.insertAfter(4, 2);
        list.insertAfter(5, 3);

        System.out.println("Zmodyfikowana lista:");
        list.display();

        list.insertBefore(6, 1);
        list.insertBefore(7, 4);

        System.out.println("Zmodyfikowana lista:");
        list.display();

        list.moveAfter(4, 6);

        System.out.println("Zmodyfikowana lista:");
        list.display();

        list.moveBefore(3, 7);

        System.out.println("Zmodyfikowana lista:");
        list.display();

        list.removeAfter(2);

        System.out.println("Zmodyfikowana lista:");
        list.display();

        list.removeBefore(6);

        System.out.println("Zmodyfikowana lista:");
        list.display();

        int poppedBack = list.popBack();
        System.out.println("poppedBack: " + poppedBack);

        int poppedFront = list.popFront();
        System.out.println("poppedFront: " + poppedFront);

        System.out.println("Zmodyfikowana lista:");
        list.display();

        int value = 2;
        System.out.println("Następny element po " + value + ": " + list.findNext(value));

        DLList<Integer> newList = new DLList<>();
        newList.pushBack(4);
        newList.pushBack(5);
        newList.pushBack(6);

        System.out.println("Połączona lista:");
        list.concat(newList);
        list.display();

        System.out.println("findNext: " + list.findNext(2));

        System.out.println("findPrev: " + list.findPrev(2));

        System.out.println("Lista:");
        list.display();
        System.out.println("size: " + list.size);
    }

    private static void priorityQueueTest() {
        System.out.println("\nPriority Queue on Binary Heap");

        PriorityQueueBinaryHeap heap = new PriorityQueueBinaryHeap();

        int[] arr = {5, 3, 8, 2, 7, 1, 6, 4};
        heap.construct(arr);

        System.out.println("Constructed Heap:");
        heap.print();

        heap.fastConstruct(arr);

        System.out.println("Fast Constructed Heap:");
        heap.print();

        heap.insert(9);
        heap.insert(0);

        System.out.println("Inserted 9, 0:");
        heap.print();

        int min = heap.findMin();
        System.out.println("Minimum: " + min);

        int delMin = heap.delMin();
        System.out.println("Deleted minimum: " + delMin);

        System.out.println("Heap after insert and delete:");
        heap.print();
    }
}