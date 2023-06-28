// https://leetcode.com/problems/combination-sum

class Solution {
    // TC --> O(2^target * k) || SC --> O(target * k) || k is avg length of the subset
    private void combinationSumUtil(int ind, int target, ArrayList<Integer> combination, int[] candidates, List<List<Integer>> allCombinations) {
        //  Assumption :: combinationSumUtil() will store all the combinations which sums to target in allCombinations data structure
        
        //base - case
        if(ind == candidates.length) return;
        if(target == 0) {
            allCombinations.add(new ArrayList<Integer>(combination));
            return;
        }
        
        //Main - logic :: pick() and non-pick
        
        //pick (as we can pick same number any numer of times), we will remain at teh same index after picking 
        if(target >= candidates[ind]) {
            combination.add(candidates[ind]);
            combinationSumUtil(ind, target - candidates[ind], combination, candidates, allCombinations);
            combination.remove(combination.size()-1);
        }
        
        //not-pick (we are no more interested in elment at index = ind, so we move further index)
        combinationSumUtil(ind+1, target, combination, candidates, allCombinations);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        combinationSumUtil(0, target, combination, candidates, allCombinations);
        return allCombinations;
    }
}