// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int min=1;
        int max=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        while(min<=max){
            int mid=(min+max)/2;
            if(operations(nums,maxOperations,mid)){
                ans=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return ans;
        
    }
     public boolean operations(int[] nums, int maxOperations,int mid){
        int operations=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=2*mid&&nums[i]>mid){
                operations++;
            }
            if(nums[i]>2*mid){
                int element=nums[i];
                while(element>mid){
                    element=element-mid;
                    operations++;
                }
            }
        }
        if(operations<=maxOperations){
            return true;
        }
        else{
            return false;
        }
    }
}