public class MinimumEditDistance {

    static int[][] matrix;

    static int med(char[] s1, int size1, char[] s2, int size2) {
        int i = 0, k = 0;
        for (i = 1; i < size1; i++ ) {
            for (k = 1; k < size2; k++) {
                if(s1[i-1] == s2[k-1]) {
                    matrix[i][k] = matrix[i-1][k-1];
                } else {
                    matrix[i][k] = Math.min(matrix[i-1][k-1], Math.min(matrix[i-1][k], matrix[i][k-1]))+1;
                }
            }
        }
        return matrix[i-1][k-1];
    }

    static void reconstruct(){};

    static public void main(String[] args) {
        char[] s1 = "azced".toCharArray();
        char[] s2 = "abcdef".toCharArray();
        matrix = new int[s1.length+1][s2.length+1];
        for (int i = 0; i < s1.length+1; i++) {
            matrix[i][0] = i;
        }
        for (int i = 0; i < s2.length+1; i++) {
            matrix[0][i] = i;
        }
        System.out.println(med(s1, s1.length+1, s2, s2.length+1));
        for (int i=0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }

}
