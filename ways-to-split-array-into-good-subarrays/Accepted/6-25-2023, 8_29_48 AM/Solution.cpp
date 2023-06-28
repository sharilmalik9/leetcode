// https://leetcode.com/problems/ways-to-split-array-into-good-subarrays

class Solution {
public:
    int numberOfGoodSubarraySplits(vector<int>& nums) {
        int n=nums.size();
        long long int  ansme=1;
        int mod=1e9 +7;
        int idx=0;
        while(idx<n && nums[idx]!=1){
            idx++;
        }
        if(idx==n)return 0;
        int countme=0;
        
        for(idx;idx<n;idx++){
            if(nums[idx]==1){
                ansme*=(countme+1);
                ansme%=mod;
                countme=0;
            }
            else{
                countme++;
            }
        }
        return ansme;
              
    }
};