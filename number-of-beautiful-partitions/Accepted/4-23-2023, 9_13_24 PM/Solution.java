// https://leetcode.com/problems/number-of-beautiful-partitions

class Solution {
     HashSet<Integer> prime;
    public int beautifulPartitions(String s, int k, int minLength) {
       prime=new HashSet<>();
       prime.add(2);
       prime.add(3);
       prime.add(5);
       prime.add(7);
        int[][] dp = new int[s.length()][k+1];
        for(int[] i: dp){
           Arrays.fill(i, -1);
        }
        
        return dfs(s, k, 0, dp,minLength);
        
    }
     public int dfs(String s, int k, int i, int[][] dp,int minLength) {
        if (i == s.length() && k==0) return 1;
        if(k==0){
            return 0;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }

        if (!prime.contains(s.charAt(i)-'0')) return 0;
       
        int ans = 0;
        if(i+minLength-1>=s.length()){
            return 0;

        }
      
        
        for (int j = i+minLength-1; j < s.length()-(k-1)*minLength; j++) {
           
            if (prime.contains(s.charAt(j)-'0')) {
                continue;
            }
            ans = (ans + dfs(s, k-1, j + 1, dp,minLength)) % 1000000007;
        }
        return dp[i][k]= ans;
    }
}