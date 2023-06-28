// https://leetcode.com/problems/number-of-ways-to-separate-numbers

class Solution {
    int n;
    int mod=1000000007;
    public int numberOfCombinations(String num) {
        n=num.length();
        return rec(num,0,"");
    }
    public int rec(String num,int idx,String prev){
        if(idx==n){
            return 1;
        }
        int ans=0;
        for(int i=idx;i<n;i++){
            if(i==idx && num.charAt(i)=='0'){
              //  continue;
                break;
            }
            String no=num.substring(idx,i+1);
            if(no.length()<prev.length()){
                continue;
            }
        //    System.out.println(no);
            if(no.length()>prev.length() || compare(no,prev)){
                ans=(ans+rec(num,i+1,no))%mod;
            }

        }
        return ans;
    }
     public boolean compare(String number,String last){
        for(int i=0;i<number.length();i++){
            int n1=number.charAt(i)-'0';
            int n2=last.charAt(i)-'0';
            if(n1>n2)
                return true;
            else if(n1<n2)
                return false;
        }
        return true;
    }
}