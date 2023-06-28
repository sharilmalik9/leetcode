// https://leetcode.com/problems/stone-game-iv

class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp= new boolean[n+1];
        int till=1;
        int square=2;
        dp[1]=true;
        for(int i=2;i<n+1;i++){
            if(i==square*square){
                square++;
                till++;
                dp[i]=true;
            }

            else{
                for(int j=1;j<=till;j++){
                    if(dp[i-j*j]==false){
                        dp[i]=true;
                        break;
                    }
                }

                



            }

        }
        return dp[n];
        
    }
}