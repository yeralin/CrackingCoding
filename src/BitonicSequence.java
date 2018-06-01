import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* Modified binary search
Find bitonic point in given bitonic sequence
You are given a bitonic sequence, the task is to find X value in it.
A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

 */

public class BitonicSequence {

    static int modifiedBinarySearch(int[] arr, int low, int high, int memo, int x) {
        if (high < low) return -1;
        int mid = (low+high)/2;
        if (arr[mid] == x) return arr[mid];
        if (memo != -1 && arr[mid] < memo) { // Reversed part
            if (arr[mid] < x) {
                return modifiedBinarySearch(arr, low, mid-1, memo, x);
            } else {
                return modifiedBinarySearch(arr, mid+1, high, memo, x);
            }
        }
        if (arr[mid] > x && arr[low] <= x) {
            return modifiedBinarySearch(arr, low, mid-1, memo, x);
        } else {
            memo = arr[mid];
            return modifiedBinarySearch(arr, mid+1, high, memo, x);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1, 0};
        System.out.println(modifiedBinarySearch(arr, 0, arr.length, -1, 3));
    }
}
