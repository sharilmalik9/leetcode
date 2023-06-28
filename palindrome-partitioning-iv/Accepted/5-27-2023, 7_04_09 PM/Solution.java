// https://leetcode.com/problems/palindrome-partitioning-iv

// class Solution {
//         Boolean[][] dp;
//         Boolean[][] paloo;
//         int n;
//     public boolean checkPartitioning(String s) {
//         n=s.length();
//         dp=new Boolean[n+1][3];
//         paloo=new Boolean[n+1][n+1];
//         return check(s,0,2);
//     }
//     public boolean check(String s,int i,int m){
//         if(m==0 && i<n){
                  
//             if(palin(s,i,n-1)){
               
//                 return dp[i][0]=true;
//             }
//             return dp[i][0]=false;
//         }
//         if(dp[i][m]!=null){
//             return dp[i][m];
//         }
//         boolean ans=false;
//         for(int k=i;k<n;k++){
//             if(palin(s,i,k)){
//                 ans=ans || check(s,k+1,m-1);
//             }
//         }
//         return dp[i][m]=ans;
//     }
   
//      boolean palin(String string, int i, int j){
//          if(paloo[i][j]!=null){
//              return paloo[i][j];
//          }
//       while(i < j){
//       if(string.charAt(i) != string.charAt(j))
//         return paloo[i][j]=false; 
//       i++;
//       j--;
//     }
//     return paloo[i][j]=true;
//   }
    
// }

class Solution {
    public boolean checkPartitioning(String s) {
        palindromeDp = new Boolean[s.length()+1][s.length()+1];
        mainDp = new Boolean[s.length()+1][4];
        boolean ans = helper(s,0,3);
        return ans;
    }
    Boolean palindromeDp[][];
    Boolean mainDp[][];
    public boolean helper(String s, int i, int cuts){
        if(mainDp[i][cuts] != null){
            return mainDp[i][cuts];
        }
        if(i == s.length()){
            if(cuts == 0){return true;}
            return false;
        }
        if(cuts == 0){return false;}
        for(int k=i;k<s.length();k++){
            if(isPalindrome(s,i,k)){
                if(helper(s,k+1,cuts-1)){return mainDp[i][cuts] = true;}
            }
        }
        return mainDp[i][cuts] = false;
    }
    public boolean isPalindrome(String s, int i, int j){
        if(palindromeDp[i][j]!=null){return palindromeDp[i][j];}
        if(i>=j){return palindromeDp[i][j] = true;}
        if(s.charAt(i) == s.charAt(j)){return palindromeDp[i][j] = isPalindrome(s, i+1, j-1);}
        return palindromeDp[i][j] = false;
    }
}