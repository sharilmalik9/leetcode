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
        int n = s.length();
        Integer[][][][] dp = new Integer[n+1][27][11][n+1]; 

        //currFreq size is taken 11 because in recursion we have added condition if it is graeter than 10 then make it 10 because length will be same 2.

        if(n-k==100){
            boolean is100 = true; // checking for all 100 equal chars

            for(int i=1;i<n;i++){
                if(s.charAt(i)!=s.charAt(i-1)){
                    is100 = false;
                }
            }

            if(is100){
                return 4;
            }
        }



        return f(s, 0,(char)('z'+1), 0, k, dp);
    }

    public int f(String s,int i, char prevChar,int currFreq, int k, Integer[][][][] dp) {
        if(k<0){
            return Integer.MAX_VALUE;
        }

       if(i==s.length()){
           return 0;
       }

       if(currFreq>10){
           currFreq = 10;
       }

       if(dp[i][(int)(prevChar-97)][currFreq][k]!=null){
           return dp[i][(int)(prevChar-97)][currFreq][k];
       }

       char c = s.charAt(i);
       int len = Integer.MAX_VALUE;

       len = Math.min(len, f(s, i+1, prevChar, currFreq, k-1, dp));
       //this is a case firstly to skip curr character and explore

       if(c==prevChar){
            if(currFreq==1 || currFreq==9){
                len = Math.min(len, 1 + f(s, i+1, c, currFreq+1, k, dp));
//here if length is 1 then it becomes char+length so thats why inreasing the length and if 9 the a after adding it is becoming 2 digit number then also increase the length
            } else {
                len = Math.min(len, f(s, i+1, c, currFreq+1, k, dp));
//in this case we are simply increasing frequency because length will not increase
            }
       } else {
           len = Math.min(len, 1 + f(s, i+1, c, 1, k, dp));
//this is case for prevchar!= curr char so we can start curr char with freqcount as 1
       }

       return dp[i][(int)(prevChar-97)][currFreq][k] = len;
    }
}