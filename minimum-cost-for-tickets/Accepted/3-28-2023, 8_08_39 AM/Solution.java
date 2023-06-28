// https://leetcode.com/problems/minimum-cost-for-tickets

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        dp[0] = 0;
        
        int j = 0;
        for(int i=1;i<dp.length;i++){
            if(j==days.length){
                break;
            }
            
            if(days[j]!=i){
                dp[i] = dp[i-1];
            } else {
                
                
                int t1 = costs[0] + dp[i-1];
                int t2 = costs[1] + dp[Math.max(0, i-7)];
                int t3 = costs[2] + dp[Math.max(0, i-30)];
                
                dp[i] = Math.min(t1, Math.min(t2, t3));
                j++;
            }
        }
        
        return dp[days[days.length-1]];
        
    }
}