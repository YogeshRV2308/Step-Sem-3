package assignment;
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: answer[i] contains the product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Multiply by the running product of all elements to the right of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i]; // Update running suffix product
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] res1 = productExceptSelf(new int[] { 1, 2, 3, 4 });
        for (int x : res1) System.out.print(x + " "); // 24 12 8 6
        System.out.println();

        int[] res2 = productExceptSelf(new int[] { -1, 1, 0, -3, 3 });
        for (int x : res2) System.out.print(x + " "); // 0 0 9 0 0
    }
}