// https://leetcode.com/problems/where-will-the-ball-fall

class Solution {
    
    public int[] findBall(int[][] grid){
        int[] ans= new int[grid[0].length];
        int[][] dp=new int[grid.length][grid[0].length];
       
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=help(0,i,grid,dp);
        }      
        
       return ans; 
        
        
    }
    public int help(int i,int j,int[][] grid,int[][] dp){
        if(i==grid.length){
            return j;
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        if(grid[i][j]==1){
            if( j+1==grid[0].length || grid[i][j+1]==-1 ){
                return -1;
            }
        }
         if(grid[i][j]==-1){
            if(grid[i][j-1]==1 || j-1==-1){
                return -1;
            }
        }
        if(grid[i][j]==1){
            return help(i+1,j+1,grid,dp);
        }
        return help(i+1,j-1,grid,dp);
    }
    
}