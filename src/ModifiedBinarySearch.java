import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModifiedBinarySearch {

    public static int mds(int[] arr, int t, int l, int h) {
        int m = (h+l)/2;
        if (arr[m] == t) return m;
        if (arr[m] > t) {
            if ((arr[l] <= t) || (arr[l] > arr[m])) {
                return mds(arr, t ,l, m-1);
            } else {
                return mds(arr, t, m+1, h);
            }
        }
        if (arr[m] <= t) {
            if ((arr[h] >= t) || (arr[h] < arr[m])) {
                return mds(arr, t, m+1, h);
            } else {
                return mds(arr, t, l, m-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3};
        System.out.println(mds(arr, 3, 0, arr.length-1));

    }
}
