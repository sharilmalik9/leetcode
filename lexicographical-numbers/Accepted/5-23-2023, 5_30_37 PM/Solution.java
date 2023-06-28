// https://leetcode.com/problems/lexicographical-numbers

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, n, 1); // Start at 1
        return ans;
    }
    
    private void dfs(List<Integer> ans, int n, int curr) {
        if (curr > n) return; // Terminate condition
        ans.add(curr); // Add curr to the List
        dfs(ans, n, 10*curr); // Prioritize (compared to += 1) adding a 0 to current number's end
        if (curr % 10 < 9) { // The condition is to avoid counting a number for multiple times 
            dfs(ans, n, curr + 1); // Plus 1 to the current number
        }
    }
}