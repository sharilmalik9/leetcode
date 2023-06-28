// https://leetcode.com/problems/power-of-heroes

class Solution {
    public int sumOfPower(int[] nums) {
        // int ans=0;
        // int mod=1000000007;
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     ans+=(nums[i]*nums[i]*nums[i])%mod;

        //     for(int j=i+1;j<nums.length;j++){
        //         ans+=(nums[i]*nums[j]*nums[j]*Math.pow(2,j-i-1))%mod;

        //     }
        // }
       
        Arrays.sort(nums);
        long result = 0;
        long prev = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            result += (prev*nums[i] + ((1L * nums[i] * nums[i]) % 1000000007) * nums[i]) % 1000000007;
            prev = (2 * prev + 1L*nums[i] * nums[i]) % 1000000007;;
        }
        return (int)(result % 1000000007);
    

        
    }
}