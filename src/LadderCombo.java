import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* Dynamic Programming: Ladder three step combo
    A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
    steps at a time. Implement a method to count how many possible ways the child can run up the
    stairs.
 */
public class LadderCombo {

    static int ladder(int n, int[] memo) {
        if (n == 1) { return 1; }
        if (n == 2) { return 2; }
        if (n == 3) { return 4; }
        if (memo[n] == 0) {
            memo[n-3] = ladder(n-3, memo);
            memo[n-2] = ladder(n-2, memo);
            memo[n-1] = ladder(n-1, memo);
            memo[n] = memo[n-3] + memo[n-2] + memo[n-1];
        }
        return memo[n];
    }

    static int ladder(int n) {
        if (n == 1) { return 1; }
        if (n == 2) { return 2; }
        if (n == 3) { return 4; }
        return ladder(n-1) + ladder(n-2) + ladder(n-3);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ladder(4, new int[7]));
        System.out.println(ladder(4));
    }
}
