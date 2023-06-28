// https://leetcode.com/problems/sell-diminishing-valued-colored-balls

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:inventory){
            pq.add(i);
        }
        int ans=0;
        int curr=0;
        int mod=1000000007;
        while(orders!=0){
           curr=pq.poll();
           ans=(ans+curr)%mod;
           pq.add(curr-1);
           orders--;
        }
        return ans;
    }
}