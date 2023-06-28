// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        //dp[i][j] = dp[j][index of (Ni+Nj)] + 1 
        int n= arr.length , max= 0;
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<arr.length;i++) map.put(arr[i],i);
        int dp[][] = new int[n][n];
        for (int i=n-1;i>=1;i--){
            for (int j=i-1;j>=0;j--){
                dp[j][i] = 2;
                if (map.containsKey(arr[i]+arr[j])){
                    dp[j][i] = 1 + dp[i][map.get(arr[i]+arr[j])];
                } 
                max = Math.max (max, dp[j][i]);
            }
        }
        return (max<3)?0:max;
    }
}