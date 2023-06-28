// https://leetcode.com/problems/longest-nice-subarray

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int ans=1;
        int or_res=0;
        int i=0;
        int j;
        for(j=0;j<n;j++){
            while(j<n && ((or_res & nums[j])==0)){
                or_res=or_res | nums[j];
                j++;
            }
            ans=Math.max(ans,j-i);
            if(j==n) break;
            while(i<j && ((or_res & nums[j])!=0)){
                or_res^=nums[i];
                i++;
            }
            if(i==j){
                or_res|=nums[j];
            }
            else j--;
        }
        return ans;
    }
}