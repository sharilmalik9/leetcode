// https://leetcode.com/problems/stone-game-vii

class Solution {
    int dp[][];
    public int stoneGameVII(int[] stones) {
        dp = new int[stones.length][stones.length];
        return score(stones, 0, stones.length - 1, Arrays.stream(stones).sum());
    }
    int score(int[] stones, int l, int r, int sum) {
        if(l == r) return 0;
        if(dp[l][r] != 0) return dp[l][r];
        int left = score(stones, l + 1, r, sum - stones[l]);
        int right = score(stones, l, r - 1, sum - stones[r]);
        dp[l][r] = Math.max(sum - stones[l] - left, sum - stones[r] - right);
        return dp[l][r];
    }
}