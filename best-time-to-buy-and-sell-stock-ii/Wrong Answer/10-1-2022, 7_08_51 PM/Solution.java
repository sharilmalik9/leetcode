// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
       List<Integer> ans= new ArrayList<>();
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                ans.add(prices[i]-prices[i-1]);

            }
        }

        
        Collections.sort(ans);
        
        int finalans=ans.get(ans.size()-1)+ans.get(ans.size()-2);
        
        return finalans;
        
    }
}