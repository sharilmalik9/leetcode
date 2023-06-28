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
        if(idx==0){

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
        reverse(nums,idx+1);
    }
    public void reverse(int[] nums,int i ){
        int start=i;
        int end=nums.length-1;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}