// https://leetcode.com/problems/minimum-moves-to-equal-array-elements

class Solution {
    public int minMoves(int[] nums) {
        int smallest=Integer.MAX_VALUE;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]<smallest){
                smallest=nums[i];
            }
        }
        int sum=0;
        for(int i=0 ; i<nums.length ; i++){
            sum+=(nums[i]-smallest);
        }
        return sum;
    }
}