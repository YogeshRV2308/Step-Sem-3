public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        // Compare every element with all subsequent elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Found a matching pair
                }
            }
        }
        return false; // No duplicates found after full check
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 })); // true
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 })); // false
    }
}