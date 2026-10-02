package assignment;
public class FindMinRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost element, min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise min is in left half (and could be mid itself)
                right = mid;
            }
        }

        return nums[left]; // left == right points to minimum element
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));       // 1
        System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 })); // 0
        System.out.println(findMin(new int[] { 11, 13, 15, 17 }));      // 11
    }
}