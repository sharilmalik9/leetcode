// https://leetcode.com/problems/count-subarrays-with-fixed-bounds

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start=0;
        int min=-1;
        int max=-1;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(val<minK || val>maxK){
                start=i+1;
                min=-1;
                max=-1;
            
            }
            if(val==minK){
                min=i;
            }
            if(val==maxK){
                max=i;
            }
            if(max!=-1 && min!=-1){
                int hey=Math.min(max,min);
                long sub=hey-start+1;
                ans+=sub;
            }
            
        }
        return ans;
    }
}