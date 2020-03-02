
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinations {

    static String[] CONST = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> generateCombo(char c, List<String> list) {
        List<String> combos = new ArrayList<>();
        for (String s : list) {
            combos.add(c+s);
        }
        return combos;
    }

    public static List<String> letterCombinations(char[] arr, int i) {
        List<String> target = new ArrayList<>();
        List<String> ret = null;
        if (i < arr.length-1) {
            ret = letterCombinations(arr, ++i);
            i--;
        }
        int digit = arr[i]-'1'+1;
        if (ret == null) {
            for (char c : CONST[digit].toCharArray()) {
                target.addAll(Arrays.asList(String.valueOf(c)));
            }
        } else {
            for (char c : CONST[digit].toCharArray()) {
                target.addAll(generateCombo(c, ret));
            }
        }
        return target;
    }

    public static List<String> letterCombinations(String digits) {
        return letterCombinations(digits.toCharArray(), 0);
    }

    public static void main(String[] args) {
    }
}
