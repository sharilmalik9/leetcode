// https://leetcode.com/problems/subtree-of-another-tree

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
     
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root==null){
            return true;
        } 
        boolean left;
        boolean right;
         
        if(root.val==subRoot.val){
             left=isSubtree(root.left,subRoot.left);
             right=isSubtree(root.right,subRoot.right);
            
            
        }
        else{
            left= isSubtree(root.left,subRoot);
            right=isSubtree(root.right,subRoot);
        }
        return left && right;
        
    }
}