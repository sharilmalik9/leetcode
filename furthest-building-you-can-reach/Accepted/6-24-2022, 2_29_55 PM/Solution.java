// https://leetcode.com/problems/furthest-building-you-can-reach

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            int difference = heights[i+1]-heights[i];
            if(difference>0){
                pq.add(difference);
                
            }
            if(pq.size()>ladders){
                bricks-=pq.poll();
            }
            if(bricks<0){
                return i;
            }
           
        }
        return heights.length-1;
    }
}