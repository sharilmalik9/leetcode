// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
          int n =prices.length;
      int[][] dp= new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
           
            for(int j=0;j<=1;j++){
                int profit=0;
                if(j==1){
                    profit=Math.max(dp[i+1][0]-prices[i],dp[i+1][1]);
                }
                else{
                    profit=Math.max(dp[i+1][1]+prices[i]-fee,dp[i+1][0]);
                }
                dp[i][j]=profit;
                
            }
            
        }
        return dp[0][1];
        
    }
}