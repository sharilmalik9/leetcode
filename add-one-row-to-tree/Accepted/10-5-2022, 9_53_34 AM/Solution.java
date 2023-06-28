// https://leetcode.com/problems/add-one-row-to-tree

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
public TreeNode addOneRow(TreeNode root, int val, int depth) {
if (depth == 1) {
TreeNode t = new TreeNode(val);
t.left = root;
return t;
}

    helper(root, val, depth, 1);
    return root;
}

private void helper(TreeNode root, int v, int d, int currLevel) {
    if (currLevel == d-1) {
        TreeNode t1 = new TreeNode(v);
        TreeNode t2 = new TreeNode(v);
        
        t1.left = root.left;
        t2.right = root.right;
        root.left = t1;
        root.right = t2;
        
        return;
    }
    
    if (root.left != null) {
        helper(root.left, v, d, currLevel + 1);
    }
    
    if (root.right != null) {
        helper(root.right, v, d, currLevel + 1);
    }
}
}