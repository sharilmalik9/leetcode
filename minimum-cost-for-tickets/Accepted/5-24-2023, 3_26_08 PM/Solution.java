// https://leetcode.com/problems/minimum-cost-for-tickets

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp= new int[366];
        boolean[]  travel=new boolean[366];
        for(int i:days){
            travel[i]=true;
        }
        for(int i=1;i<366;i++){
            if(!travel[i]){
                dp[i]=dp[i-1];
            }
            else{
                int t1 = costs[0] + dp[i-1];
                int t2 = costs[1] + dp[Math.max(0, i-7)];
                int t3 = costs[2] + dp[Math.max(0, i-30)];
                
                dp[i] = Math.min(t1, Math.min(t2, t3));
                   
            }
        }
        return dp[365];
    }
}