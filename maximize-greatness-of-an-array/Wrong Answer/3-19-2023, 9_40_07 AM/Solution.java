// https://leetcode.com/problems/maximize-greatness-of-an-array

class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int aval=0;
        while(nums[i]==nums[i+1]){
            i++;
            aval++;
        }
        i++;
        aval++;
        while(i<nums.length){
            int curr=0;
            if(nums[i]!=nums[i-1]){
                i++;
            }
            while(i<nums.length && nums[i]==nums[i-1]){
                curr++;
                i++;

            }
            if(aval<curr){
                aval=curr;
            }
            else{
                aval=aval-curr+curr;
            }
        }
        return nums.length-aval;
    }
}