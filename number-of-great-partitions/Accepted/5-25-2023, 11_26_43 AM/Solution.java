// https://leetcode.com/problems/number-of-great-partitions

class Solution {
    public int countPartitions(int[] nums, int k) {
        long MOD = 1000_000_007;
        int n = nums.length;
        long total = 0, ans = 1;
        for (int num:nums) {
            total += num;
            ans = ans * 2 % MOD;// to avoid overflow
        }
        if (total < 2*k) return 0;
        long[][] dp = new long[n+1][k];
        for (int i=0;i<=n;i++) dp[i][0] = 1;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<k;j++) {
                if (j - nums[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-nums[i-1]])%MOD;//to avoid overflow
                }
            }
        }
        for (int i=0;i<k;i++) {
            ans -= dp[n][i] * 2;// the ans could be negative number
        }
        return (int)((ans%MOD+ MOD)%MOD);//since the ans could be negative number, so we need to add MOD

    }
}