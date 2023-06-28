// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
         int ptr1=0;
        int ptr2=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ptr1++;
                count++;

            }
            else{

               nums[ptr2]=nums[ptr1];
               ptr1++;
               ptr2++;

            }
        }

        for(int i=0;i<count;i++){
            nums[nums.length-1-i]=0;

        }
    }
}