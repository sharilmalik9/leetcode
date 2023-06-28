// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array

class Solution {
    public int differenceOfSum(int[] nums) {
        int sum1=0;
        int sum2=0;
        for(int i:nums){
            sum1+=i;
            while(i>0){
                sum2+=i%10;
                i=i/10;
            }
             
        }
        return Math.abs(sum1-sum2);
        
    }
}