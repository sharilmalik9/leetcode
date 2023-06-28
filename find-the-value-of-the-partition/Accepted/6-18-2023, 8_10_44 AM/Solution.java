// https://leetcode.com/problems/find-the-value-of-the-partition

class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            ans=Math.min(nums[i+1]-nums[i],ans);
            
            
        }
        return ans;
        
        
    }
}