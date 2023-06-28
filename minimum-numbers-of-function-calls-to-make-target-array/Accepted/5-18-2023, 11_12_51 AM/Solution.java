// https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array

class Solution {
    public int minOperations(int[] nums) {
                int max = 0;
        int ans = 0;
        for(int n : nums){
            if(n == 0)continue;
            int div = 0;
            while(n != 1){
                if(n % 2 == 1){
                    ans++;
                    n--;
                }
                n = n/2;
                div++;
            }
            ans++;
            max = Math.max(max,div);
        }
        return ans + max;
        
    }
}