import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* Number of occurrence
    Given a sorted array C[] and a number X, write a function that counts the occurrences of X in C[].
 */
public class NumberOfOccurrence {

    static int occur(int[] arr, int x) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int first = first(arr, x, 0, arr.length-1);
        if (first == -1) {
            return -1;
        }
        int second = second(arr, x, 0, arr.length-1);
        if (second == -1) {
            return first;
        }
        return (second+1)-first;
    }

    static int second(int[] arr, int x, int low, int high) {
        if (high < low) return -1;
        int mid = (high+low)/2;
        if (mid+1 < arr.length && arr[mid+1] != x && arr[mid] == x) return mid;
        if (arr[mid] <= x) {
            return second(arr, x, mid+1, high);
        } else {
            return second(arr, x, low, mid-1);
        }
    }

    static int first(int[] arr, int x, int low, int high) {
        if (high < low) return -1;
        int mid = (high+low)/2;
        if ((mid-1 >= 0 && arr[mid-1] != x && arr[mid] == x) || (mid == 0 && arr[mid] == x)) {
            return mid;
        }
        if (arr[mid] < x) {
            return first(arr, x, mid+1, high);
        } else {
            return first(arr, x, low, mid-1);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(occur(new int[] {1, 1, 2, 2, 2, 2, 3}, 3));
    }
}
