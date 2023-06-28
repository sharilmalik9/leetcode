// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] freq= new int[101];
        int[] ans= new int[nums.length-k+1];
        int idx=1;
        for(int i=0;i<k;i++){
            freq[50+nums[i]]++;
        }
        ans[0]=elementcheck(freq,x);
        freq[50+nums[0]]--;
       
        int start=1;
        for(int i=k;i<nums.length;i++){
            freq[50+nums[i]]++;
            ans[idx]=elementcheck(freq,x);
          
            idx++;
            freq[50+nums[start]]--;
            start++;
        }
        return ans;
    }
    public int elementcheck(int[] freq,int x){
       int ans=0;
       for(int i=0;i<101;i++){
           if(freq[i]>0){
               x-=freq[i];
           }
           if(x<=0){
               ans=i-50;
               break; 
           }
       }
       if(ans>=0){
           return 0;
       }
       return ans;

    }
}