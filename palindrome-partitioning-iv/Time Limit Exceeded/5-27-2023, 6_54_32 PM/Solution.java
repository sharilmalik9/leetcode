// https://leetcode.com/problems/palindrome-partitioning-iv

class Solution {
    public boolean checkPartitioning(String s) {
        return check(s,0,2);
    }
    public boolean check(String s,int i,int m){
        //  if( i==s.length()){
        //      return true;
        //  }
        // System.out.println(s.substring(0,s.length()));
        if(m==0 && i<s.length()){
                  
            if(palin(s,i,s.length()-1)){
               
                return true;
            }
            return false;
        }
        
        boolean ans=false;
        for(int k=i;k<s.length();k++){
            if(palin(s,i,k)){
                ans=ans || check(s,k+1,m-1);
            }
        }
        return ans;
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