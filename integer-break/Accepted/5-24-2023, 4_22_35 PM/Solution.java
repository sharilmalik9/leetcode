// https://leetcode.com/problems/integer-break

class Solution {
    int ans=0;
    public int integerBreak(int n) {
        rec(n,1,1,0,0);
        return ans;
    }
    public void rec(int n,int i,int product,int sum,int parts){
        if(sum==n && parts>=2){
            ans=Math.max(ans,product);
            return;
        }
        if(sum>n){
            return ;
        }
        for(int k=i;k<n;k++){
            rec(n,k,product*k,sum+k,parts+1);
        }

    }
}