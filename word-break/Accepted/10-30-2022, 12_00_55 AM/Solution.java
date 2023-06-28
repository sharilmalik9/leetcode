// https://leetcode.com/problems/word-break

class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo=new int[s.length()];
        return helper(0,s,wordDict)==1? true :false;
    }
    int helper(int i ,String s ,List<String> list){
        if(i>=s.length()){
            return 1;
        }
        if(memo[i]!=0){
            return memo[i];
        }
        for(int k=i;k<=s.length();k++){
            
            if(list.contains(s.substring(i,k))){
                if(helper(k,s,list)==1){
                    return memo[i]=1;
                }
            }
        }
        return memo[i]=-1;
    }
}