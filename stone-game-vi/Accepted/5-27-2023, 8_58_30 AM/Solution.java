// https://leetcode.com/problems/stone-game-vi

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> b[2]-a[2]);
        for(int i=0;i<aliceValues.length;i++){
            pq.add(new int[]{aliceValues[i],bobValues[i],aliceValues[i]+bobValues[i]});
        }
        int ans1=0;
        int ans2=0;
        boolean turn=true;
        while(pq.size()!=0){
          
            if(turn){
                ans1+=pq.poll()[0];
                turn=!turn;

            }
            else{
                ans2+=pq.poll()[1];
                turn=!turn;
            }
        }
       
        if(ans1>ans2){
            return 1;
        }
        if(ans2>ans1){
            return -1;
        }
        return 0;

    }
}