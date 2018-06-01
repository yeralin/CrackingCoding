import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* Recursion
    Write a recursive function to multiply two positive integers without using the
    "*" operator.You can use addition, subtraction, and bit shifting, but you should minimize the number
    of those operations.
 */

public class RecursiveMultiplication {

    static int recursiveMultiply(int ans, int a, int b) {
        if (b == 0) return ans;
        if (b % 2 == 0) {
            return recursiveMultiply(ans+(a<<1), a, b/2);
        } else {
            return recursiveMultiply(ans+a, a, b-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(recursiveMultiply( 0, 7,6));
    }
}
