// https://leetcode.com/problems/restore-the-array

class Solution {
    int mod=1000000007;
    public int numberOfArrays(String s, int k) {
        return rec(s,0,0,k);
    }
    public int rec(String s,int no,int idx,int k){
        if(idx==s.length()){
           
            return 1;
        }
        long ans=0;
          
        if(s.charAt(idx)=='0'){
            if(no!=0 && no*10<=k){
                ans=rec(s,no*10,idx+1,k);
                 return (int)ans%mod;
            }
            else{
           
                return 0;
            }
            
        }
        else if(no*10+(s.charAt(idx)-'0')<=k){
            ans=rec(s,no*10+(s.charAt(idx)-'0'),idx+1,k);
        }
        if(no!=0){
             ans+=rec(s,s.charAt(idx)-'0',idx+1,k);
        }
      
        ans%=mod;
         System.out.println("hoho");
        return (int)ans;
    }
}