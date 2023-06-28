// https://leetcode.com/problems/combination-sum-ii

class Solution {
     HashSet<List<Integer>> ans= new HashSet<>();
    List<Integer> ls=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        rec(candidates,target,0);
        return new ArrayList<>(ans);
    }
     public void rec(int[] cadidates,int target,int i){
        if(target==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(target<0){
            return;
        }
        if(i==cadidates.length){
            return;
        }
        ls.add(cadidates[i]);
        rec(cadidates,target-cadidates[i],i+1);
        ls.remove(ls.size()-1);
        rec(cadidates,target,i+1);

    }
}