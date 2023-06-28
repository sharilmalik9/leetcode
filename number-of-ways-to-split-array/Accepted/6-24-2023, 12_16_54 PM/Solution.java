// https://leetcode.com/problems/number-of-ways-to-split-array

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long[] pre=new long[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=nums[i]+pre[i-1];
        }        
        long sum=pre[n-1];
        int ans=0;
        for(int i=0;i<n-1;i++){
            if(pre[i]>=sum-pre[i]) ans++;
        }
        return ans;
    }
}