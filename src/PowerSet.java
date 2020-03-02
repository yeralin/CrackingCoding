import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class PowerSet {

    /* Dynamic Programming
        Power Set: Write a method to return all subsets of a set.
     */
    static List<List<Integer>> subsets(List<Integer> subset, List<List<Integer>> subsets) {
        if (subsets.contains(subset) || subset.size() == 0) return subsets;
        subsets.add(new ArrayList<>(subset));
        for (int i = 0; i < subset.size(); i++) {
            Integer temp = subset.remove(i);
            subsets = subsets(subset, subsets);
            subset.add(i, temp);
        }
        return subsets;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        List<List<Integer>> s = subsets(l, new ArrayList<>());
        System.out.println(s.size());
    }
}
