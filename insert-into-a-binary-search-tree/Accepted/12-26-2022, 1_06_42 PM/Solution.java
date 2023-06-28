// https://leetcode.com/problems/insert-into-a-binary-search-tree

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode valf=new TreeNode(val);
        if(root==null){
            return valf;
        }
        help(root, valf);
        return root;
    }
    public TreeNode help(TreeNode root,TreeNode val){
        if(root==null){
            return val;
        }
        if(val.val>root.val){
            root.right=help(root.right,val);
        }
        else{
            root.left=help(root.left,val);
        }
        return root;
    }
}