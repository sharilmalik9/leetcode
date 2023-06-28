// https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings

class Solution {
    Integer[] dp;
    public int maxPalindromes(String s, int k) {

        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) set.add(c);
        if(set.size() == 1) return s.length()/k;

        dp = new Integer[s.length()];
        return helper(s, 0, k);   
    }
    public int helper(String s, int index, int k) {
        if(index == s.length()) return 0;
        if(dp[index] != null) return dp[index];

        int max = 0;
        for(int i=index+k; i<=s.length(); i++) {
            if(isPalindrome(s, index, i-1)) {
                max = Math.max(max, helper(s, i, k)+1);
            }
        }
        return dp[index] = Math.max(max, helper(s, index+1, k));
    }
    public boolean isPalindrome(String s, int start, int end) {

        while(start<end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}