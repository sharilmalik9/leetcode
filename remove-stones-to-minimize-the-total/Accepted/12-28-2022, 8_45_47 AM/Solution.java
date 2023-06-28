// https://leetcode.com/problems/remove-stones-to-minimize-the-total

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<piles.length;i++){
            pq.add(piles[i]);
        }
        while(k!=0){
            int curr=pq.poll();
            curr=curr-curr/2;
            pq.add(curr);
            k--;
        }
        int ans=0;
        while(pq.size()!=0){
            ans+=pq.poll();

        }
        return ans;
        
    }
}