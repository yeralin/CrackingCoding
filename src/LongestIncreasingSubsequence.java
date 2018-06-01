public class LongestIncreasingSubsequence {

    static int lis(int[] arr) {
        int max = -1;
        int[] temp = new int[arr.length];
        for (int i = 0; i < temp.length; i++) temp[i] = 1;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && temp[i] < (temp[j]+1)) {
                    temp[i] = temp[j]+1;
                    if (temp[i] > max) {
                        max = temp[i];
                    }
                }
            }
        }
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
        return max;
    }

    static public void main(String[] args) {
        int[] arr = new int[] {10,22,9,33,21,50,41,60};
        System.out.println(lis(arr));
    }
}
