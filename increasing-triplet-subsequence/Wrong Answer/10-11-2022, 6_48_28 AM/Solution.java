// https://leetcode.com/problems/increasing-triplet-subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        
        int i=Integer.MIN_VALUE;
        int j=Integer.MIN_VALUE;
        for(int k:nums){
            if(k<=i){
                i=k;
            }
            else if(k<=j){
                j=k;
            }
            else{
                return true;
            }
            
            
        }
        return false;
    }
    
}