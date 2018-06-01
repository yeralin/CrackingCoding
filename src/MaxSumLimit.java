public class MaxSumLimit {

    public static int maxSum(int[] arr, int i, int n, int limit) {
        if (n > limit || n < 0) {
            return Integer.MIN_VALUE;
        }
        if(i >= arr.length) {
            return n;
        }
        int plus = maxSum(arr, i+1, arr[i]+n, limit);
        int minus = maxSum(arr, i+1, n-arr[i], limit);
        return Math.max(plus, minus);
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 6, 4, 5};
        int start = 1;
        int limit = 15;
        System.out.println(maxSum(arr, 0, start, limit));
    }
}
