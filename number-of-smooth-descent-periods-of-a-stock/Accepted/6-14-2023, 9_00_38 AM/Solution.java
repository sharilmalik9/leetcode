// https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock

class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=0;
        int start=0;
        int end=1;
        while(end<prices.length){
            if(prices[end]+1==prices[end-1]){
                ans+=(end-start);
            }
            else{
                start=end;
            }
            end++;
        }
        return prices.length+ans;
        
    }
}