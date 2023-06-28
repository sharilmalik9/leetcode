// https://leetcode.com/problems/non-negative-integers-without-consecutive-ones

class Solution {
    String s;
    public int findIntegers(int n) {
        s=Integer.toBinaryString(n);
        return rec(0,-1,true);
    }
    public int rec(int idx,int prev,boolean bounded){
        if(idx>=s.length()){
            return 1;
        }
        int ans=0;
        ans+=rec(idx+1,0,bounded && s.charAt(idx)=='0');
        if(bounded){
            if(s.charAt(idx)=='1' && prev!=1 ){
                  ans+=rec(idx+1,1,bounded && s.charAt(idx)=='1');
            }
        }
        else{
            if(prev!=1){
                ans+=rec(idx+1,1,bounded);
            }


        }
        return ans;

    }
}