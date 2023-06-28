// https://leetcode.com/problems/special-permutations

class Solution {
    static int mod=1000000007;
    public int specialPerm(int[] nums){
        return permute(nums);
        
        
    }
     public int permute(int[] letters) {
       
        int ans=dfs(0,-1, new boolean[letters.length] ,letters);
        return ans;
    }

    private static int dfs(int idx,int prev, boolean[] used,  int[] letters) {
        if (idx == used.length) {
            return 1;
          
        }
        int ans=0;
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            if(prev==-1){
            used[i] = true;
           ans+= dfs(idx+1,letters[i], used,  letters);
            used[i] = false;
                
            }
            if(prev!=-1 && (prev%letters[i]==0 || letters[i]%prev==0)){
           
            used[i] = true;
            ans+=dfs(idx+1,letters[i], used,  letters);
          
            used[i] = false;
                
            }
        }
        return ans%mod;
    }    
}