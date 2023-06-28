// https://leetcode.com/problems/check-completeness-of-a-binary-tree

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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.right==null && root.left==null){
            return true;
        }
        if(root.right==null && root.left!=null){
            return isCompleteTree(root.left);
        }
        if(root.left==null && root.right!=null){
            return false;
        }
        return isCompleteTree(root.left) && isCompleteTree(root.right);
    }
}