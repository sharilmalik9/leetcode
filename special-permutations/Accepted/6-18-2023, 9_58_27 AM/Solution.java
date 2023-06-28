// https://leetcode.com/problems/special-permutations

class Solution {
 int[][] dp;

    public int solve(int[] nums, int hehe, int i, int maski) {
        if (i == nums.length) {
            return 1;
        }
        if (dp[hehe + 1][maski] != -1) {
            return dp[hehe + 1][maski];
        }
        int tot = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((maski & (1 << j)) != 0) {
                continue;
            }
            if (hehe == -1 || nums[hehe] % nums[j] == 0 || nums[j] % nums[hehe] == 0) {
                tot += solve(nums, j, i + 1, maski | (1 << j));
            }
            tot %= 1000000007;
        }
        dp[hehe + 1][maski] = tot;
        return dp[hehe+ 1][maski];
    }

    public int specialPerm(int[] nums) {
        dp = new int[20][(1 << 14) ];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, -1, 0, 0);
    }
}