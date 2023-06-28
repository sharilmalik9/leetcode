// https://leetcode.com/problems/numbers-at-most-n-given-digit-set

class Solution {
    String s;
    String[] digits;
    Integer dp[][][];
    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = Integer.toString(n);
        this.digits = digits;
        dp = new Integer[s.length()][2][2];

        return f(0,true, false) - 1;
        
    }

    public int f(int idx, boolean bound, boolean started){

        if(idx == s.length()) {
            return 1;
        }
        if(dp[idx][bound ? 1: 0][started ? 1: 0] != null) return dp[idx][bound ? 1: 0][started ? 1: 0];

        int max = 9;
        if(bound){
            max = s.charAt(idx) - '0';
        }
        
        int ans = 0;

        if(!started){
            ans += f(idx+1,false, false );
        }
        
        for(String i : digits){
            if(i.charAt(0) - '0' <= max){
                ans += f(idx +1, bound && s.charAt(idx) == i.charAt(0), true);
            }
        }

        return dp[idx][bound ? 1: 0][started ? 1: 0] = ans;
        
    }
}