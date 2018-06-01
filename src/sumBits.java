public class sumBits {

    public static int diffBits(int a, int b) {
        int counter = 0;
        int diff = a^b;
        int comp = Math.max(a,b);
        while (comp != 0) {
            if ((diff & 1) == 1) counter++;
            diff >>= 1;
            comp >>= 1;
        }
        if ((diff & 1) == 1) counter++;
        return counter;
    }

    public static int sumBits(int[] arr) {
        int result = 0;
        for (int i=0; i < arr.length-1; i++) {
            for (int k = i+1; k < arr.length; k++) {
                int a = arr[i];
                int b = arr[k];
                result += diffBits(a,b);
            }
        }
        return result*2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5};
        System.out.println(sumBits(arr));
    }
}
