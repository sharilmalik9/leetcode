// https://leetcode.com/problems/path-sum-ii

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        helper(paths, new ArrayList<>(), root, 0, sum);
        return paths;
    }
    
    public void helper(List<List<Integer>> paths, List<Integer> path, TreeNode node, int sum, int target){
        if(node == null) return;
        path.add(node.val);
        sum += node.val;
        helper(paths, path, node.left, sum, target);
        helper(paths, path, node.right, sum, target);
        if(sum == target && node.left == null && node.right == null) paths.add(new ArrayList<>(path));
        path.remove(path.size() - 1);
    }
}