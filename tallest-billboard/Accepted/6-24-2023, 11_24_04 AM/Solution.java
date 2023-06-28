// https://leetcode.com/problems/tallest-billboard

class Solution {
    Integer[][] dp;
    public int tallestBillboard(int[] rods){
        int sum=0;
        for(int i:rods){
            sum+=i;
        }
        dp=new Integer[rods.length+1][10000];
        int ans=rec(0,0,rods);
        return ans<0 ? 0:ans;
        
    }
    public int rec(int idx,int diff,int[] rods){
        if(idx==rods.length){
            if(diff==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[idx][5000+diff]!=null){
            return dp[idx][5000+diff];
        }
      
        // not including 
        int curr=rec(idx+1,diff,rods);
        // include in one
        curr=Math.max(curr, rods[idx]+rec(idx+1,diff-rods[idx],rods));
        // include in two
        curr=Math.max(curr,rec(idx+1,diff+rods[idx],rods));
       
        return dp[idx][5000+diff]=curr;
    }
}