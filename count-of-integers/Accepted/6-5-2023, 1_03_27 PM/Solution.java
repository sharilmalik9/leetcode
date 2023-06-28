// https://leetcode.com/problems/count-of-integers

class Solution {
    int mod=1000000007;
    String s;
    int min;
    Integer[][][] dp;
    int max;
    public int count(String num1, String num2, int min_sum, int max_sum){
        int sum=0;
        dp=new Integer[23][2][401];
        for(int i=0;i<num1.length();i++){
            sum+=num1.charAt(i)-'0';
        }
        min=min_sum;
        max=max_sum;
        s=num1;
        int one=rec(0,true,0);
        s=num2;
          dp=new Integer[23][2][401];
        int two=rec(0,true,0);
        if(sum>=min_sum && sum<=max_sum){
            return (two-one+mod)%mod+1;
        }
        return (two-one+mod)%mod;


    }
    public int rec(int idx,boolean limit,int sum){
        if(sum>max){
            return 0;
        }
        if(idx==s.length()){
            if(sum<=max && sum>=min){
                return 1;
            }
            return 0;
            
        }
        if(dp[idx][limit ? 1:0][sum]!=null){
            return dp[idx][limit ? 1:0][sum];
        }

        int is=-1;
        if(limit){
         is= s.charAt(idx)-'0';
        }
        else{
            is=9;
        }
        int ans=0;
        for(int i=0;i<=is;i++){
            ans=(ans+rec(idx+1,limit && (s.charAt(idx)-'0'==i),sum+i)%mod)%mod;
        }
        return dp[idx][limit ? 1:0][sum]=ans;
    }
}