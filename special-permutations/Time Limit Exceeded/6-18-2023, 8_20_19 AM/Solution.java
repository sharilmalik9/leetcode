// https://leetcode.com/problems/special-permutations

class Solution {
    static int mod=1000000007;
    public int specialPerm(int[] nums){
        return permute(nums);
        
        
    }
     public int permute(int[] letters) {
       
        int ans=dfs(new ArrayList<>(), new boolean[letters.length] ,letters);
        return ans;
    }

    private static int dfs(List<Integer> path, boolean[] used,  int[] letters) {
        if (path.size() == used.length) {
            return 1;
          
        }
        int ans=0;
        for (int i = 0; i < used.length; i++) {
            
         
            if (used[i]) continue;
            if(path.size()==0){
                path.add(letters[i]);
            used[i] = true;
           ans+= dfs(path, used,  letters);
    
            path.remove(path.size() - 1);
            used[i] = false;
                
            }
            if(path.size()!=0 && (path.get(path.size()-1)%letters[i]==0 || letters[i]%path.get(path.size()-1)==0)){
             path.add(letters[i]);
            used[i] = true;
            ans+=dfs(path, used,  letters);
    
            path.remove(path.size() - 1);
            used[i] = false;
                
            }
        }
        return ans%mod;
    }    
}