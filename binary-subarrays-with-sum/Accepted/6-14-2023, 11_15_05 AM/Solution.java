// https://leetcode.com/problems/binary-subarrays-with-sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans=0;
        int sum=0;
        int start=0;
        int end=0;
        int temp=0;
        while(end<nums.length){
            sum+=nums[end];
            if(nums[end]==1){
                temp=0;
            }
            while(sum>goal){
                sum-=nums[start];
                start++;
            }
            while(start<=end && sum==goal){
                temp++;
                sum-=nums[start];
                start++;
            }
            ans+=temp;
            end++;
        }
        return ans;
    }
}