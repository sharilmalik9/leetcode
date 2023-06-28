// https://leetcode.com/problems/fair-distribution-of-cookies

class Solution {
    int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int acc[]=new  int[k];
        helper(cookies, acc, k,0,0);
        return ans;
    }
    void helper(int []cookies ,int[] acc ,int k,  int cur, int max){
         if(cur==cookies.length){
             ans=Math.min(max,ans);
             return ;
         }  
         for(int i=0;i<k;i++){
                acc[i]+=cookies[cur];
                int temp=max;
                max=Math.max(acc[i],max);
                helper(cookies,acc, k,cur+1,max);
                acc[i]-=cookies[cur];
                max=temp;
             }
         return ;
    }
}