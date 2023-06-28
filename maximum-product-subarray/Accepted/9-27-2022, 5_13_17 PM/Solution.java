// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
       int currsum=1;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currsum*=nums[i];
            maxsum=Math.max(currsum,maxsum);
            if(currsum==0){
                currsum=1;
            }
        }
        currsum=1;
        for(int i=nums.length-1;i>=0;i--){
            currsum*=nums[i];
            maxsum=Math.max(maxsum,currsum);
            if(currsum==0){
                currsum=1;
            }
            
}
        return maxsum;
    }
}