import java.io.File;
import java.util.Scanner;

/* Dynamic Programming
Magic Index: A magic inde
x in an array A [ 0 ••• n -1] is defined to be an index such that A[ i] =
i. Given a sorted array of non-distinct integers, write a method to find a magic index, if one exists, in
array A.

 */
public class MagicIndex {

    static int magicNum(int[] arr, int low, int high) {
        if (high < low) return -1;
        int mid = (high+low)/2;
        if (arr[mid] == mid) { // val is in Right half
            return mid;
        }
        int left = magicNum(arr, low, Math.min(arr[mid], mid-1));
        if (left >= 0) return left;

        int right = magicNum(arr, mid+1, high);
        return right;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(magicNum(arr, 0, arr.length));
    }
}