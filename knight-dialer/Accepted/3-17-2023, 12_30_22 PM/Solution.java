// https://leetcode.com/problems/knight-dialer

class Solution {
    public long mod= 1000000007;
    public int knightDialer(int n) {
      
        int[][] keypad={{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        long[][] dp= new long[10][n+1];
        long ans=0;
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(keypad[i][j]!=-1){
                    ans=(ans+validNumbers(n,i,j,dp,keypad))%mod;
                }
            }
        }
        return (int)ans;
    }
    public long  validNumbers(int n , int i , int j,long[][] dp ,int[][] grid ){
        if(i<0|| j<0 || i>=grid.length || j>=grid[0].length ){
            return 0;
        }
        int num=grid[i][j];
        if(num==-1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(dp[num][n]!=-1){
            return dp[num][n];
        }
        long value=0;
        value+= validNumbers(n-1,i-2,j+1,dp,grid)%mod;
        value+= validNumbers(n-1,i-1,j+2,dp,grid)%mod;
        value+= validNumbers(n-1,i+1,j+2,dp,grid)%mod;
        value+= validNumbers(n-1,i+2,j+1,dp,grid)%mod;
        value+= validNumbers(n-1,i+2,j-1,dp,grid)%mod;
        value+= validNumbers(n-1,i+1,j-2,dp,grid)%mod;
        value+= validNumbers(n-1,i-1,j-2,dp,grid)%mod;
        value+= validNumbers(n-1,i-2,j-1,dp,grid)%mod;
        return dp[num][n]=value%mod;
    }
}