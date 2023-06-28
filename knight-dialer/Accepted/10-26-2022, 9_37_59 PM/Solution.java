// https://leetcode.com/problems/knight-dialer

class Solution {
    
    public long mod= 1000000007;
    public int knightDialer(int n) {
        
        int[][] grid= { {1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-1} };
        
        long[][] dp= new long[10][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++)
                dp[i][j]= -1;
        }
       
        long count=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(grid[i][j]!= -1){
                    count= (count+ validNumbers(n,i,j,dp,grid))%mod;
                }
            }
        }
        
        return (int)count; 
    }
    
    private long validNumbers(int n,int i,int j,long[][] dp,int[][] grid){
        
        int row =grid.length, col =grid[0].length;
        
        if(i<0 || i>=row || j<0 || j>=col)
            return 0;
        
        if(grid[i][j]== -1)
            return 0;
        
        
        int num=grid[i][j];
        
        if(n ==1)
            return 1;
        
        if(dp[num][n]!= -1)
            return dp[num][n];
        
        long value=0;
        value+= validNumbers(n-1,i-2,j+1,dp,grid)%mod;
        value+= validNumbers(n-1,i-1,j+2,dp,grid)%mod;
        value+= validNumbers(n-1,i+1,j+2,dp,grid)%mod;
        value+= validNumbers(n-1,i+2,j+1,dp,grid)%mod;
        value+= validNumbers(n-1,i+2,j-1,dp,grid)%mod;
        value+= validNumbers(n-1,i+1,j-2,dp,grid)%mod;
        value+= validNumbers(n-1,i-1,j-2,dp,grid)%mod;
        value+= validNumbers(n-1,i-2,j-1,dp,grid)%mod;
        
        
        return dp[num][n]= value;
    }
}