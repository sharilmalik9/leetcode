// https://leetcode.com/problems/shuffle-the-array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] ans= new int[2*n];
        int idx=0;
        int t=0;
        int p=n;
        while(idx<2*n){
            ans[idx]=nums[t];
            t++;
            idx++;
            ans[idx]=nums[p];
            p++;
            idx++;

        }
        return ans;
    }
}