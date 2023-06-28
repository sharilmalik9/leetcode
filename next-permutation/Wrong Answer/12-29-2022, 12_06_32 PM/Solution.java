// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag=true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                flag=false;
            }
        }
        if(flag){
            Arrays.sort(nums);
            return;
        }
        int idx=nums.length-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                idx=i-1;
                break;
            }
        }
        int idx2=nums.length-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[idx]){
                idx2=i;
                break;
            }
        }
        int temp=nums[idx];
        nums[idx]=nums[idx2];
        nums[idx2]=temp;
    }
}