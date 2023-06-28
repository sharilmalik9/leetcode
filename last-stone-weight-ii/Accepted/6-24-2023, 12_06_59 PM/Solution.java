// https://leetcode.com/problems/last-stone-weight-ii

class Solution {
    int rec(int[] stones, int cur, int[][] dp, int i, int sum){
        if(i == stones.length){
            if(cur<0) return 10000;
            else return 0;
        } 
        if(dp[i][cur+sum] != -1){
            return dp[i][cur+sum];
        }
        int add = rec(stones, cur+ stones[i], dp, i+1, sum) + stones[i];
        int sub = rec(stones, cur - stones[i], dp, i+1, sum) - stones[i];

        dp[i][cur+sum] = Math.min(add, sub);
        return dp[i][cur+sum];
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i:stones) sum+=i;
        int[][] dp = new int[stones.length][2*sum + 1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return rec(stones, 0, dp, 0, sum);
    }
}