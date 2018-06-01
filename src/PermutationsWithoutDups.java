import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* PermutationsWithoutDups
Write a method to compute all permutations of a string of unique
characters
 */

public class PermutationsWithoutDups {

    static List<String> permutateWODups(String s, int start, int end, List<String> perms) {
        if (start == end-1) {
            perms.add(s);
            return perms;
        }
        perms = permutateWODups(s.substring(start, end-1), start, end-1, perms);
        List<String> toReturn = new ArrayList<>();
        Iterator<String> it = perms.iterator();
        do {
            String perm = it.next();
            String workOn = s.substring(s.length()-1);
            for (int i = 0; i < perm.length()+1; i++) {
                StringBuffer sb = new StringBuffer(perm);
                sb.insert(i, workOn);
                toReturn.add(sb.toString());
            }
        } while(it.hasNext());
        return toReturn;
    }

    public static void main(String[] args) throws Exception {
        String s = "abc";
        List<String> result = permutateWODups(s, 0, s.length(), new ArrayList<String>());
        //Size is N! aka. factorial(s.length())
        System.out.println(result);
    }
}
