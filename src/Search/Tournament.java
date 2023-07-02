package Search;

public class Tournament {

    public static int second(int[] arr, int len) {
        int[] min = minimum(arr, 0, len - 1);
        return min[1];
    }


    private static int[] minimum(int[] arr, int l, int r) {
        int[] ret = new int[2];
        if (l == r) {
            ret[0] = arr[l];
            ret[1] = Integer.MAX_VALUE;
        }
        else {
            int m = (l + r) / 2;
            int[] l_min = minimum(arr, l, m);
            int[] r_min = minimum(arr, m + 1, r);
            if (l_min[0] < r_min[0]) {
                ret = l_min;
                ret[1] = Math.min(ret[1], r_min[0]);
            } else {
                ret = r_min;
                ret[1] = Math.min(ret[1], l_min[0]);
            }
        }
        return ret;
    }
}
