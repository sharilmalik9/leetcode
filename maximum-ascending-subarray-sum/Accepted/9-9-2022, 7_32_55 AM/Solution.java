// https://leetcode.com/problems/maximum-ascending-subarray-sum

class Solution {
    public int maxAscendingSum(int[] nums) {
        int index=0;
        int maxsum=0;
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                sum+=nums[i];
            }
            else{
                maxsum=Math.max(sum,maxsum);
                sum=nums[i];
            }
        }
        maxsum=Math.max(sum,maxsum);
        return maxsum;
    }
}