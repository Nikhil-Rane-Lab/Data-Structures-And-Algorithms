package DSA.array;

public class BuyAndSellStock1 {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; //means we are buying the stock
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; //means we are selling the stock
            }
        }

        return maxProfit;
    }
}

/**
    TC : O(n)
    SC : O(1)
 */
