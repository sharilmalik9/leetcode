// https://leetcode.com/problems/maximum-alternating-subsequence-sum

class Solution {
    public long maxAlternatingSum(int[] nums) {
        return rec(nums,0,0,0,0);
    }
    public long rec(int[] nums,int idx,int len,int oddsum,int evensum){
        if(idx==nums.length){
            return Math.abs(oddsum-evensum);
        }
        long include=0;
        
        if(len%2==0){
            include=rec(nums,idx+1,len+1,oddsum+nums[idx],evensum);
        }
        else{
            include=rec(nums,idx+1,len+1,oddsum,evensum+nums[idx]);
        }
        long dont=rec(nums,idx+1,len,oddsum,evensum);
        return Math.max(include,dont);
        

    }
}