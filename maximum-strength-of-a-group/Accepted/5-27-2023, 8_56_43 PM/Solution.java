// https://leetcode.com/problems/maximum-strength-of-a-group

class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length == 1) return nums[0];
        int neg= 0;
        for(int i: nums){
            if(i<0) neg ++;
        }
        long ansoh= 0;
        if(neg % 2 != 0){
             Arrays.sort(nums);
            for(int i = 0; i< nums.length; i++){
                if((i != nums.length -1 && nums[i] <0 && nums[i+1] >=0) || (i== nums.length -1 && nums[i]<0) ){
                    continue;
                }
                if(nums[i] != 0){
                    if(ansoh == 0) ansoh = 1;
                    ansoh = ansoh*nums[i];
                }
            }
        }else{
            for(int i: nums){
                if(i != 0){
                    if(ansoh == 0) ansoh = 1;
                    ansoh = ansoh*i;
                }
            }
           
        }
        
        return ansoh;
    }
    
    
    
}