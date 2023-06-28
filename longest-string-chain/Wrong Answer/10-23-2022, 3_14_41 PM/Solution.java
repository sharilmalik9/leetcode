// https://leetcode.com/problems/longest-string-chain

class Solution {
    public int longestStrChain(String[] words){
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(comp(words[j],words[i]) && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            ans=Math.max(ans,dp[i]);
            
        }
         
        return ans;
    }
    public boolean comp(String s,String t){
        if(s.length()+1!=t.length()){
            return false;
        }
        int idx1=0;
        int idx2=0;
        while(idx1<s.length()){
            if(s.charAt(idx1)==t.charAt(idx2)){
                idx1++;
                idx2++;
            }
            else{
                idx2++;
            }
            
        }
        if(idx2==t.length()){
            return true;
        }
        return false;
    }
}