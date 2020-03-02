public class MoveZerosToEnd {

	public static boolean fastForward(int[] nums, int s) {
        for (int i = s+1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[s] = nums[i];
                nums[i] = 0;
                return false;
            }
        }
        for (int i = s; i < nums.length; i++) {
            nums[i] = 0;
        }
        return true;
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if(fastForward(nums, i)) {
                	break;
				}
            }
        }
    }

	public static void main(String[] args) {
		moveZeroes(new int[] {0,0,0,0,0,1});
	}
}
