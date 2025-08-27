package two_pointers;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3};
        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        System.out.print("[");
        for (int i = 0; i <= j; i++) {
            System.out.print(nums[i]);
            if (i < j) System.out.print(", ");
        }
        System.out.println("]");
    }
}
