// https://leetcode.com/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int answer = 0;
        int ans1 = main(nums, 0, nums.length-2);
        int ans2 = main(nums, 1, nums.length - 1);
        return Math.max(ans1, ans2);
        
    }
    public int main(int[] nums, int start , int end){
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start+1], nums[start]);
        
        for(int i = start+2; i <= end; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[end];
    }
}