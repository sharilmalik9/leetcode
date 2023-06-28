// https://leetcode.com/problems/maximize-greatness-of-an-array

class Solution {
    public int maximizeGreatness(int[] nums) {

       Arrays.sort(nums);
       int i = 0;
       int j = 0;
       int count = 0;
       while(j<nums.length){
           if(nums[i]<nums[j]){
               count++;
               i++;
           }
           j++;
       }
       return count;
    }
}