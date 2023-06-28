// https://leetcode.com/problems/palindrome-partitioning-iv

class Solution {
        Boolean[][] dp;
    public boolean checkPartitioning(String s) {
        dp=new Boolean[s.length()+1][3];
        return check(s,0,2);
    }
    public boolean check(String s,int i,int m){
        if(m==0 && i<s.length()){
                  
            if(palin(s,i,s.length()-1)){
               
                return dp[i][0]=true;
            }
            return false;
        }
        if(dp[i][m]!=null){
            return dp[i][m];
        }
        boolean ans=false;
        for(int k=i;k<s.length();k++){
            if(palin(s,i,k)){
                ans=ans || check(s,k+1,m-1);
            }
        }
        return dp[i][m]=ans;
    }
   
     boolean palin(String string, int i, int j){
      while(i < j){
      if(string.charAt(i) != string.charAt(j))
        return false; 
      i++;
      j--;
    }
    return true;
  }
    
}