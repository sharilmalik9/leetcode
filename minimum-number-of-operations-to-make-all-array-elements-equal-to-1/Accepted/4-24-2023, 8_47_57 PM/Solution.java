// https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1

class Solution {
    public int minOperations(int[] nums) {
        int noOfOnes = 0;
        for (int num : nums) {
            if (num == 1) noOfOnes++;
        }
        if (noOfOnes > 0) return nums.length - noOfOnes;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i]; // Take initial GCD of the [i, j] range
            for (int j = i + 1; j < nums.length; j++) {
                gcd = findGCD(gcd, nums[j]);  // For every new j, take gcd(nums[j], previousGCD) 
                if (gcd == 1) ans = Math.min(ans, j - i + nums.length - 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int findGCD(int n1, int n2) {
       int gcd = 1;

    for (int i = 1; i <= n1 && i <= n2; ++i) {

      // check if i perfectly divides both n1 and n2
      if (n1 % i == 0 && n2 % i == 0)
        gcd = i;
    }
    return gcd;
    
    }
}