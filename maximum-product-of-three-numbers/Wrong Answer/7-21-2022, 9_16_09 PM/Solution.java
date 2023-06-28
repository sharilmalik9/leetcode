// https://leetcode.com/problems/maximum-product-of-three-numbers

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans=1;
        for(int i=nums.length-3;i<nums.length;i++){
            ans*=nums[i];
            
}
        return ans;
        
    }
}