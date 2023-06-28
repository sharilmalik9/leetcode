// https://leetcode.com/problems/special-permutations

class Solution {
    static int mod=1000000007;
   static Integer[][] dp;
     int[] ls;
    static boolean[] used;
    public int specialPerm(int[] nums){
         dp=new Integer[nums.length+2][nums.length+1];
        ls=nums;
        used=new boolean[nums.length];
        int ans=dfs(0,-1,nums);
        return ans;    
    }
    private static int dfs(int idx,int prev,  int[] letters) {
        if (idx == used.length) {
            return 1;
        }
        int ans=0;
        if(dp[prev+1][idx]!=null &&  used[prev] && used[idx]){
            return dp[prev+1][idx];
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            if(prev==-1 || (prev!=-1 && (letters[prev]%letters[i]==0 || letters[i]%letters[prev]==0))){
            used[i] = true;
            ans+=dfs(idx+1,i,  letters);
            used[i] = false;
                
            }
        }
        return dp[prev+1][idx]=ans%mod;
    } 
    
   
//     public int rec(int prev,int idx){
//         if(idx>=ls.length){
            
//             return 1;
//         }
//         int ans=0;
//         for(int i=0;i<ls.length;i++){
//             if(vis[i]==true){
//                 continue;
//             }
//             if(prev==-1){
//                 int sup=ls[i];
//                 vis[i]=true;
//                 ans+=rec(sup,idx+1);
//                 vis[i]=false;
//             }
//             System.out.println(prev+" "+ls[i]);
//             if((ls[i]%prev==0 || prev % ls[i]==0) && !vis[i] ){
//                 int sup=ls[i];
//                 vis[i]=true;
//                 ans+=rec(sup,idx+1);
//                 vis[i]=false;
//             }

//         }
//         return ans%mod;
//     }
    
}