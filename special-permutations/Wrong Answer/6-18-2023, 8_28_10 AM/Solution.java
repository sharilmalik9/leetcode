// https://leetcode.com/problems/special-permutations

class Solution {
    static int mod=1000000007;
    static Integer[][] dp;
    public int specialPerm(int[] nums){
        dp=new Integer[nums.length+2][nums.length+1];
        int ans=dfs(0,-1, new boolean[nums.length] ,nums);
        return ans;
        
        
    }
    private static int dfs(int idx,int prev, boolean[] used,  int[] letters) {
        if (idx == used.length) {
            return 1;
          
        }
        int ans=0;
        if(dp[prev+1][idx]!=null){
            return dp[prev+1][idx];
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            if(prev==-1){
            used[i] = true;
           ans+= dfs(idx+1,i, used,  letters);
            used[i] = false;
                
            }
            if(prev!=-1 && (letters[prev]%letters[i]==0 || letters[i]%letters[prev]==0)){
           
            used[i] = true;
            ans+=dfs(idx+1,i, used,  letters);
          
            used[i] = false;
                
            }
        }
        return dp[prev+1][idx]=ans%mod;
    }    
}