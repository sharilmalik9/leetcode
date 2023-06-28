// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {
       if(nums[0]<=nums[nums.length-1])//length==1||first is the mini
            return nums[0];
        int l=0;
        int r=nums.length-1;
        
        while(l<r){
            int mid=(l+r)/2;
            if(mid>0&&nums[mid-1]>nums[mid]&&nums[mid]<nums[mid+1])
                return nums[mid];
            if(nums[mid]>=nums[0]){
                l=mid+1;//mid not in the rotate array
            }
            else{
                r=mid-1;//mid include the rotate array
            }
        }
        return nums[l];//only left one number, in this time, l=r=mid

    }
}