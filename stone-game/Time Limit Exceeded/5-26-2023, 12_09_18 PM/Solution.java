// https://leetcode.com/problems/stone-game

class Solution {
    // turn=true=alice
    // turn =false=bob
    public boolean stoneGame(int[] piles) {
        return rec(piles,0,0,0,piles.length-1,true);
        
    }
    public boolean rec(int[] piles,int scoreAlice,int scoreBob,int start,int end,boolean turn){
        if(start>end){
            return scoreAlice>scoreBob;
        }
         boolean curr=true;
        if(turn){
            curr=false;

        }
       
        if(turn){
                curr=curr || rec(piles,scoreAlice+piles[start],scoreBob,start+1,end,false);
                 curr=curr|| rec(piles,scoreAlice+piles[end],scoreBob,start,end-1,false);
        }
        else{
                curr=curr &&  rec(piles,scoreAlice,scoreBob+piles[start],start+1,end,true);
                 curr=curr && rec(piles,scoreAlice,scoreBob+piles[end],start,end-1,true);
        }
        return curr;
    }
}