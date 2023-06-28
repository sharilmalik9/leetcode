// https://leetcode.com/problems/combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1,n,k,new LinkedList<>(),result);
        return result;
    }

    private void backtracking(int curr, int n, int k, LinkedList<Integer> currList, List<List<Integer>> result){
        if(currList.size()==k){
            result.add(new ArrayList(currList));
            return;
        }
        for(int i=curr;i<=n;i++){
            currList.add(i);
            backtracking(i+1,n,k,currList,result);
            currList.removeLast();
        }
    }
}