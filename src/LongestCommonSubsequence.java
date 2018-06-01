import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LongestCommonSubsequence {

    static int[][] matrix;

    static void lcs(char[] s1, char[] s2) {
        for (int i=1; i < matrix.length; i++) {
            for (int k = 1; k < matrix[i].length; k++) {
                if (s1[i-1] == s2[k-1]) {
                    matrix[i][k] = matrix[i-1][k-1]+1;
                } else {
                    matrix[i][k] = Math.max(matrix[i-1][k], matrix[i][k-1]);
                }
            }
        }
    }

    static char[] reconstruct(char[] s1, int i, char[] s2, int k) {
        int x = matrix[i][k];
        char[] result = new char[x];
        while(i != 0 && k != 0) {
            if (s1[i-1] == s2[k-1]) {
                result[x-1] = s1[i-1];
                i--;
                k--;
                x--;
            } else {
                if (matrix[i][k] == matrix[i][k-1]) {
                    k--;
                } else if (matrix[i][k] == matrix[i-1][k]){
                    i--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        char[] s1 = "12341".toCharArray();
        char[] s2 = "341213".toCharArray();
        matrix = new int[s1.length+1][s2.length+1];
        for(int i=0; i < s1.length; i++) {
            matrix[0][i] = 0;
        }
        for(int i=0; i < s2.length; i++) {
            matrix[i][0] = 0;
        }
        lcs(s1, s2);
        for (int i=0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println(reconstruct(s1,s1.length,s2,s2.length));
    }
}
