public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Compare every element at index i with every subsequent element at index j
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {}; // Default fallback if no pair exists
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [0, 1]
    }
}