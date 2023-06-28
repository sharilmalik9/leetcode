// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
         int[] ans={-1,-1};
        int start=0;
        int end=nums.length-1;
        int first=-1;
        int last=-1;
        int i=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]<target){
                start=mid+1;
            }
            if(nums[mid]>target){
                end=mid-1;

            }
            if(nums[mid]==target){
                for( i=start;i<=mid;i++){
                    if(nums[i]==target){
                        first=i;
                        break;
                    }
                }
                for(i=end;i>=mid;i--){
                    if(nums[i]==target){
                        last=i;
                        break;

                    }
                }
                ans[0]=first;
                ans[1]=last;
                return ans;

            }
        }

        return ans;
        
    }
}