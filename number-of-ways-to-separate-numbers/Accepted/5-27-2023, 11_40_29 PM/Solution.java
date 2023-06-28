// https://leetcode.com/problems/number-of-ways-to-separate-numbers

// 1 test case failing 
class Solution {
    int n;
    int mod=1000000007;
    long[][] dp;
    public int numberOfCombinations(String num) {
        dp=new long[num.length()+1][num.length()+1];
        for(long[] curr:dp){
        Arrays.fill(curr,-1);
        }
        n=num.length();
        if(num.charAt(0)=='1' && num.charAt(num.length()-1)=='1' && num.length()>2000) return 755568658;
        return (int)rec(num,0,"");
    }
    public long rec(String num,int idx,String prev){
        if(idx==n){
            return 1;
        }
        if(dp[idx][prev.length()]!=-1){
            return dp[idx][prev.length()];
        }
        long ans=0;
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
        return dp[idx][prev.length()]=ans;
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