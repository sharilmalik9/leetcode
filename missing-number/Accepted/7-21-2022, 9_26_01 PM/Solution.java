// https://leetcode.com/problems/missing-number

class Solution {
    public int missingNumber(int[] nums) {
        boolean[] p= new boolean[nums.length+1];
        for(int i:nums){
            p[i]=true;
        }
        for(int i=0;i<p.length;i++){
            if(!p[i]){
                return i;
            }
        }
        return -1;
        
        
    }
}