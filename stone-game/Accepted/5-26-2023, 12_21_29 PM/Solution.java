// https://leetcode.com/problems/stone-game

// class Solution {
//     // turn=true=alice==1
//     // turn =false=bob
//     public boolean stoneGame(int[] piles) {
//         Boolean[][][] dp= new Boolean[piles.length][piles.length][2];
//         return rec(piles,0,0,0,piles.length-1,true,dp);
        
//     }
//     public boolean rec(int[] piles,int scoreAlice,int scoreBob,int start,int end,boolean turn,Boolean[][][] dp){
//         if(start>end){
//             return scoreAlice>scoreBob;
//         }
//         int k=0;
//          boolean curr=true;
//         if(turn){
//             curr=false;
//             k=1;

//         }
//         if(dp[start][end][k]!=null){
//             return dp[start][end][k];
//         }

//         if(turn){
//                 curr=curr || rec(piles,scoreAlice+piles[start],scoreBob,start+1,end,false,dp);
//                  curr=curr|| rec(piles,scoreAlice+piles[end],scoreBob,start,end-1,false,dp);
//         }
//         else{
//                 curr=curr &&  rec(piles,scoreAlice,scoreBob+piles[start],start+1,end,true,dp);
//                 curr=curr && rec(piles,scoreAlice,scoreBob+piles[end],start,end-1,true,dp);
//         }
//         return dp[start][end][k]=curr;
//     }
// }

class Solution {
    public boolean stoneGame(int[] piles) {
    
        int a=0,b= 0;
        int i=0;
        int j=piles.length-1;
        while(i<j){
            if(piles[i]>piles[j]){
            a+=piles[i++];
            b+=piles[j--];
            }
         else{
             a+=piles[j--];
             b+=piles[i++];
         }
            
            
        }
        if(a>b){
            return true;
        }else{
            return false;
        }
    }
}