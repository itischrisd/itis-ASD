package Sort;

public class Insertion {

    public static void sort(int[] arr, int len) {
        int i = 1;
        while (i < len) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j]  = temp;
            i++;
        }
    }
}
