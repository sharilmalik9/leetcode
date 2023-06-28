// https://leetcode.com/problems/divisor-game

class Solution {
    public boolean divisorGame(int n) {
//         int[] dp= new int[n+1];
//         dp[0]=0;
//         dp[1]=0;
//        // dp[2]=1;
        
//         for(int i=2;i<n+1;i++){
//             for(int j=1;j<i;j++){
//                 if(i%j==0){
//                     if(dp[i-j]==0){
//                         dp[i]=1;
//                     }
//                 }
//             }
            
// }
//         return dp[n]==1;
        return n%2==0 ?true:false;
        
    }
}