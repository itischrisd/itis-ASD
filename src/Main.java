import Container.Node;
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
}
