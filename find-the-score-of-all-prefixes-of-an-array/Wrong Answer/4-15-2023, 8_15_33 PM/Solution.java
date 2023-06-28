// https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array

class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] ans=new long[nums.length];
        long[] pre=new long[nums.length];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            pre[i]=nums[i]+max;
        }
        ans[0]=pre[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i]+pre[i];
        }
        return ans;
        
        
    }
}