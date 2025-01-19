package DSA.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class L121BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // No transactions possible
        }

        int minPrice = Integer.MAX_VALUE; // Track the minimum price seen so far
        int maxProfit = 0; // Track the maximum profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Here we bought the stock (tracking the lowest price)
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Here we sold the stock (calculating max profit)
            }
        }

        return maxProfit; // Return the maximum profit found
    }
}
// TC: O(n)
// SC: O(1)