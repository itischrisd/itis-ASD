import Container.*;
import Search.*;
import Sort.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        sequentialSearchTest();
//        jumpSearchTest();
//        binarySearchTest();

//        selectionSortTest();
//        inseertionSortTest();
//        mergeSortTest();
        mergeSortListTest();
    }

    private static void sequentialSearchTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        int len = arr.length;

        for (int i : arr)
            System.out.println("Found " + i + " at index: " + Sequential.search(arr, len, i));

        System.out.println("Not found 10, ret: " + Sequential.search(arr, len, 10));
        System.out.println("Not found 52, ret: " + Sequential.search(arr, len, 52));
        System.out.println("Not found 100, ret: " + Sequential.search(arr, len, 100));
    }

    private static void jumpSearchTest() {
        int[] arr = new int[]{19, 24, 28, 32, 50, 51, 54, 69, 73, 79, 80, 83, 84, 92, 95};
        int len = arr.length;

        for (int i : arr)
            System.out.println("Found " + i + " at index: " + Jump.search(arr, len, i));

        System.out.println("Not found 10, ret: " + Jump.search(arr, len, 10));
        System.out.println("Not found 52, ret: " + Jump.search(arr, len, 52));
        System.out.println("Not found 100, ret: " + Jump.search(arr, len, 100));
    }

    private static void binarySearchTest() {
        int[] arr = new int[]{19, 24, 28, 32, 50, 51, 54, 69, 73, 79, 80, 83, 84, 92, 95};
        int len = arr.length;

        for (int i : arr)
            System.out.println("Found " + i + " at index: " + Binary.search(arr, len, i));

        System.out.println("Not found 10, ret: " + Binary.search(arr, len, 10));
        System.out.println("Not found 52, ret: " + Binary.search(arr, len, 52));
        System.out.println("Not found 100, ret: " + Binary.search(arr, len, 100));
    }

    private static void selectionSortTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        Selection.sort(arr, arr.length);
        System.out.println("Selection sorted: " + Arrays.toString(arr));
    }

    private static void insertionSortTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        Insertion.sort(arr, arr.length);
        System.out.println("Insertion sorted: " + Arrays.toString(arr));
    }

    private static void mergeSortTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        arr = Merge.sort(arr, arr.length);
        System.out.println("Merge sorted: " + Arrays.toString(arr));
    }

    private static void mergeSortListTest() {
        int[] arr = new int[]{69, 32, 24, 83, 50, 54, 80, 79, 19, 95, 84, 73, 92, 51, 28};
        Node<Integer> list = new Node<>(arr[0]);
        Node<Integer> curr = list;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node<>(arr[i]);
            curr = curr.next;
        }
        System.out.print("Unsorted list:\t\t");
        MergeList.printList(list);
        list = MergeList.sort(list);
        System.out.print("\nMerge sorted list:\t");
        MergeList.printList(list);
    }
}
