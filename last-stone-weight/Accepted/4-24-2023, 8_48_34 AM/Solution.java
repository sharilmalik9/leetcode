// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int i : stones){
            pq.add(i);
        }
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            if(first==second){
                continue;
            }
            else {
                pq.add(-second+first);
            }
            
           
        
    }
        if(!pq.isEmpty()){
            return pq.poll();
        }
        else{
            return 0;
        }
       
}
}