// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int pre=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=pre;
            pre=pre*nums[i];
        }
        int post=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]=ans[i]*post;
            post=post*nums[i];
        }
        return ans;
    }
}