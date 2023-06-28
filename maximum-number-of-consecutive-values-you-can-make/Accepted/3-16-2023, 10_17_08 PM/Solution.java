// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans=0;
        int i=0;
        while(i < coins.length && coins[i]<=ans+1 ){
            ans+=coins[i];
            i++;

        }
        return ans+1;
    }
}