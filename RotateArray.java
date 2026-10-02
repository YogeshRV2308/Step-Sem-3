public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        // Reduce k in case k is larger than array length
        k = k % n;

        int[] result = new int[n];

        // Map every element to its new target position
        for (int i = 0; i < n; i++) {
            int newPosition = (i + k) % n;
            result[newPosition] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rotated = rotateArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
        for (int num : rotated) {
            System.out.print(num + " "); // 5 6 7 1 2 3 4 
        }
    }
}