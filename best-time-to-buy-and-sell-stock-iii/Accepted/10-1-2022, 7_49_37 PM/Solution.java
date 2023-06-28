// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii

class Solution {
    public int maxProfit(int[] prices) {
          int n =prices.length;
      int[][][] dp= new int[n+1][2][3];
        
    
        
        for(int i=n-1;i>=0;i--){
           
            for(int j=0;j<=1;j++){
                for(int k=1;k<=2;k++){
                int profit=0;
                if(j==1){
                    profit=Math.max(dp[i+1][0][k]-prices[i],dp[i+1][1][k]);
                }
                else{
                    profit=Math.max(dp[i+1][1][k-1]+prices[i],dp[i+1][0][k]);
                }
                dp[i][j][k]=profit;
               }  
            }
            
        }
        return dp[0][1][2];
        
    }
}