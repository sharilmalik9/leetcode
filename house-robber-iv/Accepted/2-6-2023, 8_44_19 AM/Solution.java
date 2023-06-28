// https://leetcode.com/problems/house-robber-iv

class Solution {
    public int minCapability(int[] nums, int k) {
        int l=nums[0];
        int r=nums[0];
        for(int i=0;i<nums.length;i++){
            l=Math.min(nums[i],l);
            r=Math.max(nums[i],r);

        }
        while(l<r){
            int mid=(l+r)/2;
            if(valid(nums,k,mid)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
        
        
    }
    public boolean valid(int[] nums,int k,int mid){
        for(int i=0;i<nums.length;){
            if(nums[i]<=mid){
                if(--k==0){
                    return true;
                }
                i+=2;
            }
            else{
                i++;
            }

        }
        return false;
    }
   
}