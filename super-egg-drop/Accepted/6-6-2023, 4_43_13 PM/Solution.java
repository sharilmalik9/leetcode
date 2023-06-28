// https://leetcode.com/problems/super-egg-drop

class Solution {
    Integer[][] dp;
    public int superEggDrop(int k, int n){
        dp=new Integer[k+1][n+1];

        return rec(k,n);
    }
    public int rec(int eggs,int n){
        if(n<=1){
            return n;
        }
        if(eggs==1){
            return n;
        }
        if(dp[eggs][n]!=null){
            return dp[eggs][n];
        }
        int ans=Integer.MAX_VALUE;
        int start=0;
        int end=n;
        while(start<=end){
            int mid=(start+end)/2;
            int lower=0;
            int higher=0;
            if(dp[eggs-1][mid-1]!=null){
                lower=dp[eggs-1][mid-1];
            }
            else{
                lower=rec(eggs-1,mid-1);
                dp[eggs-1][mid-1]=lower;
            }
            if(dp[eggs][n-mid]!=null){
                higher=dp[eggs][n-mid];
            }
            else{
                higher=rec(eggs,n-mid);
                dp[eggs][n-mid]=higher;

            }
            if(lower>higher){
                end=mid-1;
        }
            else{
                start=mid+1;
            }
            int temp=Math.max(lower,higher);
            ans=Math.min(ans,temp);
        }
        return dp[eggs][n]=ans+1;
    }
}