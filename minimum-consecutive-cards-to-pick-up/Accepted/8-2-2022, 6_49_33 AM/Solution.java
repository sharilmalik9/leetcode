// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up

class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> mp= new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i =0;i<cards.length;i++){
            if(mp.containsKey(cards[i])){
                int card=i- mp.get(cards[i])+1;
                
                ans = Math.min(ans,card);
                
                    mp.replace(cards[i],i);
                
            }
            else{
                mp.put(cards[i],i);
                
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
}
            return ans;
           
    }
}