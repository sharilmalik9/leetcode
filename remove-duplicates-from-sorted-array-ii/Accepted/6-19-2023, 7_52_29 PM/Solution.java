// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        int p=0;

        int ele=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==ele)
            {
                count++;

            }
            else
            {
                ele=nums[i];
                count=1;
            }
            if(count<=2)
        {
            nums[p++]=nums[i];
        }
       
        }
        
        
        return p;
    }
}