// https://leetcode.com/problems/combination-sum-iv

class Solution {
    public int combinationSum4(int[] nums, int target) {
        return rec(nums,target,0);
    }
    public int rec(int[] nums,int target,int i){
        if(target==0){
            return 1;
        }
        if(i==nums.length){
            return 0;
        }
        if(target<0){
            return 0;
        }
        int ans=0;
        for(int k=0;k<nums.length;k++){
            ans+=rec(nums,target-nums[k],k);
        }
       
        return ans ;
    }
}