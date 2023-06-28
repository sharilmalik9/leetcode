// https://leetcode.com/problems/maximum-matching-of-players-with-trainers

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int s1=0;
        int s2=0;
        int cnt=0;
        while(s1<players.length&&s2<trainers.length){
            if(players[s1]<=trainers[s2]){
                s1++;
                s2++;
                cnt++;
                
            }
            else if(players[s1]>trainers[s2]){
                s2++;
            }
            
        }
        
        
        return cnt;
        
    }
}