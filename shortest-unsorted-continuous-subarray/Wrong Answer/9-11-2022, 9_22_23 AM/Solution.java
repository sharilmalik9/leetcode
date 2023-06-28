// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start=0;
        boolean first=true;
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(first){
                    start=i;
                    first=false;
                }
                else{
                     start=Math.min(start,i);
                }
               // start=Math.min(start,i);
                end=Math.max(end,i+1);
            }
        }
        if(start-end==0){
            return 0;
        }
        return end-start+1;
        
    }
}