// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                int curr=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=curr;
                return;
            }
        }
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int var=nums[start];
            nums[start]=nums[end];
            nums[end]=var;
            start++;
            end--;
        }

        
    }
}