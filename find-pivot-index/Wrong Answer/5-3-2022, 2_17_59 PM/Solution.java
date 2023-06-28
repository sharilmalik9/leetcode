// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
         int ans=0;
        int sum=0;
        int leftsum=0;
        int rightsum=0;

         for(int i:nums){
             sum+=i;
         }
         rightsum=sum-nums[0];
         for(int i=1;i<nums.length;i++){
             if(leftsum==rightsum){
                 ans=i-1;

                 break;
             }

             leftsum+=nums[i-1];
             rightsum-=nums[i];
         }
         if(leftsum!=rightsum){
             if(ans==0){
                 ans=-1;
             }
         }

         return ans;
       
        
    }
}