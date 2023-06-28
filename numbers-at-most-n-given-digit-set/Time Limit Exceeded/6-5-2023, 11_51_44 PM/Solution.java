// https://leetcode.com/problems/numbers-at-most-n-given-digit-set

class Solution {
    String s;
    char[] digit;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        s=Integer.toString(n);
        digit=new char[digits.length];
        for(int i=0;i<digits.length;i++){
            digit[i]=digits[i].charAt(0);
        }
        return rec(true,0,false)-1;
    }
    public int rec(boolean bounded,int idx,boolean started){
        if(idx>=s.length()){
            return 1;
        }
        int ans=0;
        if(!started){
            ans+=rec(bounded && s.charAt(idx)-'0'=='0',idx+1,started);
        }
        for(int i=0;i<digit.length;i++){
            if(bounded && digit[i]-'0'<=s.charAt(idx)-'0'){
                System.out.println(idx+" "+digit[i]);
                ans+=rec(bounded && digit[i]-'0'==s.charAt(idx)-'0',idx+1,true);
            }
            else if(!bounded){
                ans+=rec(bounded,idx+1,true);
            }
        }
        return ans;
    }
}