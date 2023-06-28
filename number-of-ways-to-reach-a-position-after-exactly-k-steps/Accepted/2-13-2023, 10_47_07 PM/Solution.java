// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps

class Solution {
    
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp= new int[4001][1001];
        for(int[] i : dp){
             Arrays.fill(i,-1);

        }
       
        return help(endPos,k,startPos,dp);

        
    }
    public int help(int end,int k,int curr,int[][] dp){
        if(curr==end && k==0){
            return 1;
        }
       
        if(k==0){
            return 0;
        }
        if(dp[curr+2001][k]!=-1){
            return dp[curr+2001][k];
        }
        return dp[curr+2001][k]=(help(end,k-1,curr-1,dp)+ help(end,k-1,curr+1,dp))%1000000007;

    }
}