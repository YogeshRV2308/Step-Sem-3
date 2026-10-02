public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0]; // Track the lowest price seen so far
        int maxProfit = 0;        // Track the maximum profit achievable

        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price if a cheaper day is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate potential profit if sold today
                int profitToday = prices[i] - minPrice;
                if (profitToday > maxProfit) {
                    maxProfit = profitToday;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // 5
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));    // 0
    }
}