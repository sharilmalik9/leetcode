// https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] nums) {
         int ansidx=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[ansidx]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                ansidx=i;
                count=1;
            }
        }
         count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[ansidx]==nums[i]){
                count++;
            }
        }
        return nums[ansidx];

        
        
    }
}