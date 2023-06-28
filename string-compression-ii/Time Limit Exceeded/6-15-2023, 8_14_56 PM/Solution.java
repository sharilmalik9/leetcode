// https://leetcode.com/problems/string-compression-ii

// class Solution {
//     Integer[][][][] dp;
//     public int getLengthOfOptimalCompression(String s, int k) {
//         dp=new Integer[s.length()+1][s.length()+1][27][k+1];
//        return rec(0,0,26,k,s);        
//     }
//     public int rec(int idx,int len,int prev,int k,String s){
//         if(k<0){
//             return Integer.MAX_VALUE;
//         }
//         if(idx>=s.length()){
//           return 0;
//         }
//         if(dp[idx][len][prev][k]!=null){
//             return dp[idx][len][prev][k];
//         }
//         // delete
//         int ans=rec(idx+1,len,prev,k-1,s);
//         //keep
//         int cnt=0;
//         if(s.charAt(idx)-'a'==prev){
//             if(len==1|| len==9||len==99){
//                 cnt++;    
//             }
//             ans=Math.min(ans,cnt+rec(idx+1,len+1,prev,k,s));
//         }
//         else{
//             ans=Math.min(ans,1+rec(idx+1,1,s.charAt(idx)-'a',k,s));
//         }
//         return dp[idx][len][prev][k]=ans;    
//     }

// }
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
       Integer dp[][][][] = new Integer[s.length()+1][k+1][27][101];
        return dfs(s, k, 0, (char) ('a'+26), 0, dp);
    }
    
    
    private int dfs(String s, int k, int i, char prevChar, int prevFreq, Integer dp[][][][]) {
              
        if(k<0) return Integer.MAX_VALUE;
        
        if(i==s.length()) return 0;       
        
         if(dp[i][k][prevChar-'a'][prevFreq]!=null) return dp[i][k][prevChar-'a'][prevFreq];
        
        
        
        int delete = Integer.MAX_VALUE;
        int dontDelete = Integer.MAX_VALUE;
        
        
        delete = dfs(s, k-1, i+1, prevChar, prevFreq, dp);
        if(s.charAt(i) != prevChar) {
            dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 1, dp); 
        }
        
        else if(s.charAt(i) == prevChar) {
            if(prevFreq == 1) {
                dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 2, dp);
            }
            else if(prevFreq == 9) {
                dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 10, dp);
            }
            else if(prevFreq == 99) {
                 dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 100, dp);
            } else {
                dontDelete = dfs(s,k,i+1, s.charAt(i), prevFreq+1, dp);
            }
        }
        return dp[i][k][prevChar-'a'][prevFreq] = Math.min(delete, dontDelete);
    }
}