// https://leetcode.com/problems/movement-of-robots

class Solution {
     long MOD = (long) 1e9 + 7;
    public int sumDistance(int[] nums, String s, int d) {
        int n = s.length();
        long distance = 0;
        long ans = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (sChars[i] == 'R') {
                nums[i] += d;
            } else if (sChars[i] == 'L') {
                nums[i] -= d;
            }
        }
        Arrays.sort(nums);
        for (long i = 0; i < n; i++) {
            ans += (long) nums[(int) i] * i - distance;
            ans %= MOD;
            distance += nums[(int) i];
            distance %= MOD;
        }
        return (int) (ans % MOD);
    
    }
}