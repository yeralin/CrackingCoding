public class MagicNumber {

    public static int magicSum(int n) {
        int sum = 0, i = 1;
        while (n != 0) {
            if ((n&1) == 1) {
                sum += Math.pow(5, i);
            }
            n >>= 1;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        for(int i = 1; i < 11; i++) {
            System.out.println(magicSum(i));
        }
    }
}
