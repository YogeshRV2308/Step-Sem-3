package assignment;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Base case: prefix sum of 0 occurs once initially

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if there exists a previous prefix sum such that: currentSum - target = k
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }

            // Record current prefix sum frequency
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));  // 2
        System.out.println(subarraySum(new int[] { 1, -1, 0 }, 0)); // 3
    }
}