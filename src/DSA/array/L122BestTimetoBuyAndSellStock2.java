package DSA.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
public class L122BestTimetoBuyAndSellStock2 {

    //Greedy Approach
    public int maxProfit(int[] prices) {

        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += (prices[i] - prices[i - 1]);
            }
        }

        return totalProfit;
    }
    //TC: O(N)
    //SC: O(1)
}
