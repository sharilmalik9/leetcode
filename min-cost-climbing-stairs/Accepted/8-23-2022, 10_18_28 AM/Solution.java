// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int len = cost.length;
        if(len==2)return Math.min(cost[0],cost[1]);
        
        int[] dp = new int[len];
        dp[len-1]=cost[len-1];
        dp[len-2]=cost[len-2];
        
        for(int i = len-3; i >= 0;i--){
            dp[i] = cost[i] + Math.min(dp[i+1],dp[i+2]);
        }
        
        return Math.min(dp[0],dp[1]);
    }
}