// https://leetcode.com/problems/scramble-string

class Solution {
    public boolean isScramble(String s1, String s2){

        return rec(s1,s2);
    }
    public boolean rec(String s1,String s2){
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length()<=1 || s2.length()<=1){
            return false;
        }
        int n=s2.length();
        boolean ans=false;
        for(int i=1;i<n;i++){
            boolean cond1=rec(s1.substring(0,i),s2.substring(n-i,n)) && rec(s1.substring(i,n),s2.substring(0,n-i));
            ans=ans || cond1;
            boolean cond2=rec(s1.substring(0,i),s2.substring(0,i)) && rec(s1.substring(i,n),s2.substring(i,n));
            ans=ans|| cond2;
            
        }
        return ans;
    }
}