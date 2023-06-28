// https://leetcode.com/problems/single-element-in-a-sorted-array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid==0 || mid==nums.length-1 ||(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) ){
                return nums[mid];
            }
            if(nums[mid]==nums[mid-1]){
                if((mid-start)%2!=0){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                if((end-mid)%2==0){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }



         return nums[start];
    }
}