// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int minElement=0;
        int maxDifference=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[minElement]){
               minElement=i;

            }
            else{
                maxDifference=i-minElement;
            }

        }
    
        if (maxDifference == 0) {
            return 0;
        }
        else{
        return maxDifference+1;
    }
        
    }
}