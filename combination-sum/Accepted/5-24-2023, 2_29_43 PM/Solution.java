// https://leetcode.com/problems/combination-sum

class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    List<Integer> ls=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(candidates,target,0);
        return ans;
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
        rec(cadidates,target,i+1);
        ls.add(cadidates[i]);
        rec(cadidates,target-cadidates[i],i);
        ls.remove(ls.size()-1);

    }
}