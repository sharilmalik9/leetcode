// https://leetcode.com/problems/cherry-pickup

class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp= new int[grid.length][grid[0].length][grid.length];
        int ans=help(0,0,0,grid,dp);
        return ans<0 ? 0 : ans ;
    }
    public int help(int r1,int c1,int r2,int[][] arr,int[][][] dp){
        int c2=r1+c1-r2;
        if(c1>=arr[0].length || r1>=arr.length || c2>=arr[0].length || r2>=arr.length|| arr[r1][c1]==-1 || arr[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==arr.length-1 && c1==arr[0].length-1){
            return arr[r1][c1];
        }
        if(dp[r1][c1][r2]!=0){
            return dp[r1][c1][r2];
        }
        
        int cherries=0;
        if(r1==r2 && c1==c2){
            cherries=arr[r1][c1];
            
        }
        else{
            cherries=arr[r1][c1]+arr[r2][c2];
        }
        int one=help(r1,c1+1,r2,arr,dp);
        int two=help(r1+1,c1,r2,arr,dp);
        int three=help(r1+1,c1,r2+1,arr,dp);
        int four=help(r1,c1+1,r2+1,arr,dp);
        cherries+=Math.max(one,Math.max(two,Math.max(three,four)));
        dp[r1][c1][r2]=cherries;
        return cherries;
    }
}