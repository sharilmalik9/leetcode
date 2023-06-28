// https://leetcode.com/problems/longest-arithmetic-subsequence

class Solution {
    public int longestArithSeqLength(int[] nums) {
        return rec(0,-1000,-1,nums);
        
    }
    public int rec(int idx,int diff,int prev,int[] nums){
        if(idx>=nums.length){
            return 0;
        }
        int ans=0;
        //dont include
        ans=rec(idx+1,diff,prev,nums);
        // include
        if(prev==-1){
            ans=Math.max(1+rec(idx+1,diff,idx,nums),ans);
        }
        else if(diff==-1000){
            ans=Math.max(1+rec(idx+1,nums[idx]-nums[prev],idx,nums),ans);
        }
        else if(nums[idx]-nums[prev]==diff){
            ans=Math.max(1+rec(idx+1,diff,idx,nums),ans);
        }
        return ans;
    }
}