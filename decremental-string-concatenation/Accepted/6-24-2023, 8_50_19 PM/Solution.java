// https://leetcode.com/problems/decremental-string-concatenation

class Solution {
    String[] words;
    Integer[][][] dp;
    public int minimizeConcatenatedLength(String[] words) {
        this.words = words;
        int here=0;
        dp = new Integer[words.length][27][27];
        return words[0].length() + rec(1,words[0].charAt(0) - 'a' ,words[0].charAt(words[0].length()-1) - 'a');
        
    }
    
    public int rec(int idx, int first, int last){
        if(idx == words.length) return 0;
        if(dp[idx][first][last] != null) return dp[idx][first][last];
        String curr = words[idx];
        char firstCh = (char)('a' + first);        
        char lastCh = (char)('a' + last);
        int len1 = 0;
        int len2 = 0;
        if(lastCh == curr.charAt(0)){
            len1 = curr.length() - 1;
        }else{
            len1 = curr.length();
        }
        len1 += rec(idx+1, first, (curr.charAt(curr.length()-1) - 'a') );

        if(curr.charAt(curr.length() - 1) == firstCh){
            len2 = curr.length() - 1;
        }
        else{
            len2 = curr.length();
        }
        len2 += rec(idx+1, (curr.charAt(0) - 'a'), last );
        return dp[idx][first][last] = Math.min(len1,len2);
    }
    
}