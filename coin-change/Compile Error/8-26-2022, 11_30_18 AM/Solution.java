// https://leetcode.com/problems/coin-change

// my soln - works 
// class Solution {
//     public int coinChange(int[] arr, int amt) {
//         int[]dp =new int[amt+1];

//          Arrays.fill(dp, amt + 1);
//         dp[0]=0;
// for(int i=0;i<arr.length;i++){
//     for(int j =arr[i];j<dp.length;j++){
//         dp[j]=Math.min(1+dp[j-arr[i]],dp[j]);
//     }
//     System.out.println(Arrays.toString(dp));
// }
//         if(dp[amt]==amt+1){
//             return -1;
// }
//     return dp[amt];
//     }
// }
// class Solution {    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        for(int i = 0; i < dp.length; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
