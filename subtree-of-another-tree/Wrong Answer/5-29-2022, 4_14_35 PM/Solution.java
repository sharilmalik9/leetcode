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
        if(root==null || subRoot==null){
            return true;
        } 
        if(root==null && subRoot!=null || subRoot==null && root!=null){
            return false;
        }
        boolean left;
        boolean right;
         
        if(root==subRoot){
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