// https://leetcode.com/problems/stone-game-viii

class Solution {
    public int stoneGameVIII(int[] stones) {
         int n=stones.length;
        int[] prefixSum=new int[n];
        prefixSum[0]=stones[0];
        for(int i=1;i<n;i++) {
            prefixSum[i]=prefixSum[i-1]+stones[i];
        }
        int[][] dp=new int[n+1][2];
        for(int[] i:dp) {
            Arrays.fill(i, -1);
        }
        return solve(prefixSum, 1, dp, 0);
    }
    public int solve(int[] prefixSum,int i,int[][] dp,int turn){
        if(i==prefixSum.length-1){
            return prefixSum[i];
        }
        if(dp[i][turn]!=-1){
            return  dp[i][turn];
        }
        int ans=Integer.MIN_VALUE;
       
        for(int x=i;x<prefixSum.length-1;x++){
            if(turn==0){
                ans=Math.max(ans,prefixSum[x]-solve(prefixSum,x+1,dp,1));
                ans=Math.max(ans,solve(prefixSum,x+1,dp,1));
            }
            else{
                ans=Math.max(ans,prefixSum[x]-solve(prefixSum,x+1,dp,0));
                ans=Math.max(ans,solve(prefixSum,x+1,dp,0));
            }
        }
        return dp[i][turn]=ans;
    }
}