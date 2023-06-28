// https://leetcode.com/problems/target-sum

class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        rec(nums,target,0,0);
        return ans;
        
    }
    public void rec(int[] nums,int target,int i,int curr){
        if(curr==target && i==nums.length){
            ans++;
            return;
        }
        if(i>=nums.length){
            return;
        }
        rec(nums,target,i+1,curr+nums[i]);
        rec(nums,target,i+1,curr-nums[i]);

    }
}