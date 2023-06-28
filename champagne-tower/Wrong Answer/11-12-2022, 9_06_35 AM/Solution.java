// https://leetcode.com/problems/champagne-tower

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        long[][] dp= new long[101][101];
        dp[0][0]=poured;
        for(int i=0;i<101;i++){
            for(int j=0;j<=i;j++){
                if(dp[i][j]>1){
                    dp[i+1][j]=(dp[i][j]-1)/2;
                    dp[i+1][j+1]=(dp[i][j]-1)/2;
                    dp[i][j]=1;
                }
            }
            
            
        }
        return dp[query_row][query_glass];
    }
}