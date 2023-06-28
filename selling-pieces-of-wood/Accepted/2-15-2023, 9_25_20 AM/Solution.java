// https://leetcode.com/problems/selling-pieces-of-wood

class Solution {
    public long sellingWood(int m, int n, int[][] prices){
        long[][] dp= new  long[m+1][n+1];
        for(int i=0;i<prices.length;i++){
            dp[prices[i][0]][prices[i][1]]=prices[i][2];
        }
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                for(int k=1;k<=i/2;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[k][j]+dp[i-k][j]);

                }
                for(int k=1;k<=j/2;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[i][j-k]);

                }
            }
        }
        return dp[m][n];
        
    }
}