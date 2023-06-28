// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans =1;
        int start=0;
        int end =0;
        int ansf=0;
        while(end<nums.length){
            ans*=nums[end];
            while(ans>=k){
                ans=ans/nums[start];
                start++;
            }
            
            ansf+=end-start+1;
            end++;
            
            
            
            
            
}
        return ansf;
            
            
        
        
        
        
        
    }
}