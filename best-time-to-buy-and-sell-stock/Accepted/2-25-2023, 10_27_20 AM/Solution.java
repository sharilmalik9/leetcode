// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int difference=0;

        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            difference=Math.max(prices[i]-min,difference);

            
        }
        return difference;
    }
}