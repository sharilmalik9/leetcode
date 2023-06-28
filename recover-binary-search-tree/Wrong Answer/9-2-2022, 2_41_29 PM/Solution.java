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
    TreeNode nn1=null;
    TreeNode nn2=null;
    public void recoverTree(TreeNode root) {
       
        
        helper(root,Long.MIN_VALUE,Long.MAX_VALUE, null);
        int amt=nn1.val;
        nn1.val=nn2.val;
        nn2.val=amt;
    }
    
    
    
     public boolean helper(TreeNode root,Long min,Long max, TreeNode parent){
        if(root==null){
            return true;
        }
        
        else if(root.val<=min || root.val>=max){
        System.out.println(root.val + " " + min +" "+ max);
            nn1 = parent;
            nn2 = root;

            return false;
        }
        return helper(root.left,min,Math.min(root.val,max), root) && helper(root.right,Math.max(min,root.val),max, root);
    }

}