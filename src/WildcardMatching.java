public class WildcardMatching {

    static boolean[][] matrix;

    static boolean wm(char[] str, char[] pattern) {
        matrix = new boolean[str.length+1][pattern.length+1];
        //Init
        matrix[0][0] = true;
        for (int i = 1; i < str.length; i++) {
            matrix[i][0] = false;
        }
        for (int i = 1; i < pattern.length; i++) {
            matrix[0][i] = false;
        }
        for (int j = 1; j <= pattern.length; j++) {
            if (pattern[j - 1] == '*') {
                matrix[0][j] = matrix[0][j - 1];
            }
        }

        for (int i = 1; i < str.length+1; i++) {
            for (int j = 1; j < pattern.length+1; j++) {
                if (pattern[j-1] == '?' || pattern[j-1] == str[i-1]) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else if (pattern[j-1] == '*') {
                    matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
                } else {
                    matrix[i][j] = false;
                }
            }
        }
        return matrix[str.length][pattern.length];
    }

    static public void main(String[] args) {
        String pattern = "*";
        String str = "xaylmz";
        System.out.println(wm(str.toCharArray(), pattern.toCharArray()));
        for (int i=0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }
}
