// https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k

class Solution {
    Integer[][][] dp;
    int mod=1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        dp=new Integer[grid.length][grid[0].length][k+1];
        return rec(grid,0,0,0,k);
       
    }
    public int rec(int[][] grid,int i,int j,int sum,int k){
        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(dp[i][j][sum]!=null){
            return dp[i][j][sum];
        }
        int newsum=sum+grid[i][j];
        if(i==grid.length-1 && j==grid[0].length-1){
            if(newsum%k==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        newsum=newsum%k;
        return dp[i][j][sum]=(rec(grid,i+1,j,newsum,k)+rec(grid,i,j+1,newsum,k))%mod;
    }

}