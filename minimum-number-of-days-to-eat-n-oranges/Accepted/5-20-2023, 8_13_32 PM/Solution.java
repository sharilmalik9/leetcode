// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges

class Solution {
    HashMap<Integer,Integer> dp;
    public int minDays(int n) {
        dp = new HashMap<>();
        return helper(n);
    }
    public int helper(int n){
        if(n==0) return 0; // Base Case
        if(dp.containsKey(n)) return dp.get(n); // Cache
        int temp = Integer.MAX_VALUE; // Initializing
        if(n%6==0) temp = 1+ Math.min(helper(n/2),helper(n/3)); // If n is divisible by 6,minimum will be among n/2,n/3
        else if(n%3==0)temp = 1 + Math.min(helper(n/3),helper(n-1));// n-(2*(n/3)) can be considered n/3
        else if(n%2==0)temp = 1+ Math.min(helper(n/2),helper(n-1));
        else temp = 1+helper(n-1);
        dp.put(n,temp); // memoizing
        return temp;
    }
}