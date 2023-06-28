// https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array

class Solution {
    public int minOperations(int[] nums) {
        int nozeroes=0;
        int[] rem=new int[nums.length];
        int max=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                nozeroes++;
            }
            if(nums[i]==1){
                continue;
            }
                rem[i]=nums[i]%2;
                max=Math.max(max,nums[i]/2);
            
        }
        int remans=0;
        for(int i:rem){
            remans+=i;
        }
        int ans=(nums.length-nozeroes)+max+remans;
        return ans;
    }
}