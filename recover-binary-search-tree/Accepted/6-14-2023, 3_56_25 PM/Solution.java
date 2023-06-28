// https://leetcode.com/problems/recover-binary-search-tree

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
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode middle=null;
    TreeNode last=null;
    public void recoverTree(TreeNode root){
        rec(root);
        if(last==null){
            int safe=first.val;
            first.val=middle.val;
            middle.val=safe;
        }
        else{
             int safe=first.val;
            first.val=last.val;
            last.val=safe;
        }
        
    }
    public void rec(TreeNode root){
        if(root==null){
            return;
        }
        rec(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first=prev;
                middle=root;
            }
            else{
                last=root;
            }
        }
        prev=root;
        rec(root.right);

    }
}