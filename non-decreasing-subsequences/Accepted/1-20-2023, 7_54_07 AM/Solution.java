// https://leetcode.com/problems/non-decreasing-subsequences

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
         List<List<Integer>> ans= new ArrayList<>();
         List<Integer> ls= new ArrayList<>();
         Set<List<Integer>> hs= new HashSet<>();
        
         help(hs,ls,nums,0);
         for(List<Integer> i : hs){
             if(i.size()>1){
                 ans.add(i);
             }
         }
         return ans;
    
    }
    public void help( Set<List<Integer>> hs,List<Integer> ls,int[] nums,int idx){
        
        if(idx==nums.length){
            hs.add(new ArrayList<>(ls));
            return;
        }


       help(hs,ls,nums,idx+1);
       if(ls.size()==0 || (nums[idx]>=ls.get(ls.size()-1))){
           ls.add(nums[idx]);
           help(hs,ls,nums,idx+1);
           ls.remove(ls.size()-1);
       }



    }
}