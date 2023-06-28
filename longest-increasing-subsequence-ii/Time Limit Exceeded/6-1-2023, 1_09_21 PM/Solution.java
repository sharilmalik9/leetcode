// https://leetcode.com/problems/longest-increasing-subsequence-ii

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && nums[i]-nums[j]<=k){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}