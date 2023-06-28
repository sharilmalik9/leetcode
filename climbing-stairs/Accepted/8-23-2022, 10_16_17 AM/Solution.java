// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        //If number of ways to reach n-1 th stair = x
        //   number of ways to reach n-2 th stair = y
        //   number of ways to reach n th stair = x+y
        
        int dp[] = new int[n+1];
        dp[0] = 1;    //Number of way to climb 1st stair is 1 whisch is - 1
        dp[1] = 2;    //Number of ways to climb 2nd stair are 2 : 1+1, 2
        
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n-1];
    }
}