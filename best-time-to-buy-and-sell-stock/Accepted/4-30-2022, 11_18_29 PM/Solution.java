// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int minElement =prices[0];
        int maxDifference = 0;
        for (int i = 1; i < prices.length; i++) {
            minElement=Math.min(prices[i],minElement);
            int curr_difference=prices[i]-minElement;
            maxDifference=Math.max(maxDifference,curr_difference);
        }
        return maxDifference;
        
    }
}