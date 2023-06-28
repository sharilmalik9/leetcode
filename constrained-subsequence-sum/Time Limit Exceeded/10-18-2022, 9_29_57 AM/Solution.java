// https://leetcode.com/problems/constrained-subsequence-sum

class Solution {
    public int constrainedSubsetSum(int[] nums, int k){
       int n = nums.length;
        int ans=-1;
	int[] dp = new int[n];
	for (int i = 0; i < n; i++) {
		dp[i] = nums[i];
		int maxOffset = i - k;
		for (int j = i - 1; j >= 0 && j >= maxOffset; j--) {
			dp[i] = Math.max(dp[i], nums[i] + dp[j]);
		}
        ans=Math.max(ans,dp[i]);
	}
        return ans;
        
    }
}