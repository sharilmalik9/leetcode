// https://leetcode.com/problems/maximize-greatness-of-an-array

class Solution {
    public int maximizeGreatness(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        
        Arrays.sort(nums);
        int aval=0;
        int i=1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1]){
                if(aval==0){
                    aval++;
                }
                i++;
                

            }
            else{
                int curr=1;
                while(i<nums.length && nums[i]==nums[i-1]){
                    i++;
                    curr++;
                }
                if(aval<curr){
                    aval=curr;

                }
                
            }
        }
        return nums.length-aval;
        
    }
}