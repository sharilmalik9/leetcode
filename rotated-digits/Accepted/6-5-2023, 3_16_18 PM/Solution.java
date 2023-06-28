// https://leetcode.com/problems/rotated-digits

class Solution {
    String s;
    Integer[][][] dp;
    public int rotatedDigits(int n) {
        s = Integer.toString(n);
        dp = new Integer[s.length()][2][s.length()];
        return f(0,true,0);
    }

    public int f(int i, boolean bound, int cnt){

        if(i == s.length()) {
            return cnt > 0 ? 1 : 0;
        }
        if(dp[i][bound ? 1:0][cnt] != null) return dp[i][bound ? 1:0][cnt];

        int maxDig = 9;

        if(bound){
            maxDig = s.charAt(i) - '0';
        }
        int ans = 0;
        for(int j = 0; j<=maxDig; j++){
            int add = 0;
            if(j == 3 || j == 7 || j == 4) continue;
            if(j == 2 || j ==5 || j == 6 || j == 9 ) {
                add = 1;
            }
            ans += f(i+1, bound && j == s.charAt(i) - '0', cnt + add);
            
        }

        // return ans;
        return dp[i][bound ? 1:0][cnt]=ans ;

        
    }
    
}