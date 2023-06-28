// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
 public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = 1; i <= s.length()/2; i++) {
            if(s.charAt(i)==s.charAt(0)){
                String b = s.substring(0, i);
                String res = b.repeat(l/b.length());
                // System.out.println(b);
                // System.out.println(res);
                if(s.equals(res)){
                    return true;
                }
            }
        }
        return false;
    }
}