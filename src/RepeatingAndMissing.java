import java.util.Arrays;

public class RepeatingAndMissing {

    static void repeatingAndMissing(int[] arr) {
        int[] temp = new int[arr.length+1];
        int[] dest = new int[arr.length];
        Arrays.fill(temp, 0);
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i-1];
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            dest[temp[val]-1] = val;
            temp[val]--;
        }
        int repeating = -1, missing = -1;
        int validator = 1;
        for(int i = 0; i < dest.length; i++) {
            if (dest[i] < validator) {
                repeating = dest[i];
            } else if (dest[i] > validator) {
                missing = validator;
                validator += 2;
            } else validator++;

        }
        for (int val : dest) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println(repeating + ", " + missing);
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6,7, 2, 1, 1};
        repeatingAndMissing(arr);
    }
}
