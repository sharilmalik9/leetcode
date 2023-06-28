// https://leetcode.com/problems/power-of-heroes

class Solution {
    public int sumOfPower(int[] nums) {
        int ans=0;
        int mod=1000000007;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            ans+=(nums[i]*nums[i]*nums[i])%mod;

            for(int j=i+1;j<nums.length;j++){
                ans+=(nums[i]*nums[j]*nums[j]*Math.pow(2,j-i-1))%mod;

            }
        }
        return ans;

        
    }
}