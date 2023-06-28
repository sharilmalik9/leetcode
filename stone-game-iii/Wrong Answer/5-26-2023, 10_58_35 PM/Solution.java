// https://leetcode.com/problems/stone-game-iii

class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int[] piles=stoneValue;
         //if (piles.length == 0) return 0;
         dp = new int[piles.length];

        int[] suffixSum = new int[piles.length];
        suffixSum[suffixSum.length - 1] = piles[piles.length - 1];
        for (int i = piles.length - 2; i >= 0; --i) suffixSum[i] = piles[i] + suffixSum[i + 1];
        int ans= helper(piles, suffixSum, 0);
        if(ans>suffixSum[0]-ans){
            return "Alice";
        }
        else if(ans==suffixSum[0]-ans){
            return "Tie";
        }
        else{
            return "Bob";
        }
    }
    public int helper(int[] piles, int[] suffixSum, int i) {
        if (i == piles.length) return 0;
        if (i + 3 >= piles.length) return suffixSum[i];

        if (dp[i] != 0) return dp[i];

        int result = 0;
        for (int x = 1; x <= 3; ++x) {
            result = Math.max(result, suffixSum[i] - helper(piles, suffixSum, i + x));
        }

        dp[i] = result;
        return result;
    }
}