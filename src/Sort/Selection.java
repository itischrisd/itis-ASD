package Sort;

public class Selection {

    public static void sort(int[] arr, int len) {
        int i = 0;
        while (i < len) {
            int min = indexOfMin(arr, i, len);
            swap(arr, i, min);
            i++;
        }
    }

    private static int indexOfMin(int[] arr, int i, int len) {
        int min = i;
        while (i < len) {
            if (arr[min] > arr[i])
                min = i;
            i++;
        }
        return min;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
