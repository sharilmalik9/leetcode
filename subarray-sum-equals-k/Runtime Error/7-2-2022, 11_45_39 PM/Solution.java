// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int start=0;
        int end=0;
        int count=0;
        int sum=0;
        while(end<nums.length){
            sum+=nums[end];
            if(sum<k){
                end++;
            }
            else if(sum==k){
                count++;
                sum-=nums[start];
                start++;
                end=start;
                sum=0;
                
            }
            else if(sum>k){
                sum-=nums[start];
                start++;
            }
        }
        return count;
    }
}